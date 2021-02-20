package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {
    private Object[] elements;
    private int size;
    public Queue(){
        this.elements=new Object[4];
        this.size=0;
    }
    public void validate(int index){
        if(index<=0){
            throw new IllegalStateException("invalid index");
        }
    }
    public void resize(){
        Object[] elements2=new Object[elements.length*2];
        for(int i=0;i<elements.length;i++){
            elements2[i]=elements[i];
        }
        elements=elements2;
    }

    @Override
    public void offer(E element) {
        if(this.size==elements.length){
            resize();
        }
        elements[size]=element;
        size++;
    }

    @Override
    public E poll() {
        validate(size);
        E toBeReturned=(E)elements[0];
        for(int i=0;i<size-1;i++){
            elements[i]=elements[i+1];
        }
        size--;
        return toBeReturned;
    }

    @Override
    public E peek() {
        validate(size);
        return (E)elements[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size==0){
            return true;
        }
        return false;
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
