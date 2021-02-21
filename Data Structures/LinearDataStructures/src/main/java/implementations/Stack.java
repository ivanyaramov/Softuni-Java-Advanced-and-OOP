package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {
    private Object[] elements;
    private int size;
    public Stack(){
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
    public void push(E element) {
if(this.size==elements.length){
    resize();
}
elements[size]=element;
size++;
    }

    @Override
    public E pop() {
        validate(this.size);
        E toBeReturned=(E)elements[size-1];
        size--;
        return toBeReturned;
    }

    @Override
    public E peek() {
        validate(this.size);
        return (E)elements[size-1];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if(this.size==0){
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter=size-1;
            @Override
            public boolean hasNext() {
                return counter>=0;
            }

            @Override
            public E next() {
                return (E)elements[counter--];
            }
        };
    }
}
