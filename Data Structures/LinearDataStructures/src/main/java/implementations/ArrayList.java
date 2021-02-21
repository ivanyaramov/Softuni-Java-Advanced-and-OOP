package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
private Object[] elements;
private int size;

    public ArrayList() {
        this.elements = new Object[4];
        this.size=0;
    }

    @Override
    public boolean add(E element) {
        if(this.size==elements.length){
            resize();
        }
        elements[this.size++]=element;

        return true;
    }
public void resize(){
        Object[] elements2=new Object[elements.length*2];
        for(int i=0;i<elements.length;i++){
            elements2[i]=elements[i];
        }
        elements=elements2;
}
    @Override
    public boolean add(int index, E element) {
        validate(index);
            if (this.size == elements.length) {
                resize();
            }
            for (int i = this.size; i > index; i--) {
                this.elements[i] = this.elements[i - 1];
            }
            this.elements[index] = element;
            this.size++;
            return true;

    }

    @Override
    public E get(int index) {
       validate(index);

            return (E) this.elements[index];

    }
public void validate(int index){
    if(index>=this.size||index<0){
        throw new IndexOutOfBoundsException("invalid index");
    }
}
    @Override
    public E set(int index, E element) {
        validate(index);
        this.elements[index]=element;
        return element;
    }

    @Override
    public E remove(int index) {
        validate(index);
        E toBeReturned=(E)this.elements[index];
        for(int i=index;i<this.size-1;i++){
            this.elements[i]=this.elements[i+1];
        }
        this.size--;

        return toBeReturned;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        for(int i=0;i<this.size;i++){
            if(this.elements[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        for(int i=0;i<this.size;i++){
            if(this.elements[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if(this.size>0){
            return false;
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter=0;
            @Override
            public boolean hasNext() {
                return counter<size;
            }

            @Override
            public E next() {
                return (E)elements[counter++];
            }
        };
    }
}
