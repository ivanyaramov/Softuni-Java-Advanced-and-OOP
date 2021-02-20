package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
private Node head;
private Node tail;
private int size;

    public class Node<E>{
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
            this.next=null;
        } public Node(E element,Node node) {
            this.element = element;
            this.next=node;
        }
    }

    public SinglyLinkedList() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    @Override
    public void addFirst(E element) {
Node<E> node=new Node<>(element);
if(size==0){
    this.head=node;
    this.tail=node;
}
else {
    node.next = this.head;
    this.head = node;
}
size++;



    }
    public void validate(){
        if(size==0){
            throw new IllegalStateException("invalid index");
        }
    }

    @Override
    public void addLast(E element) {
        Node<E> node=new Node<>(element);
        if(size==0){
            this.head=node;
            this.tail=node;
        }
        else {
            this.tail.next = node;
            this.tail = node;
        }
      size++;


    }

    @Override
    public E removeFirst() {
        validate();
        E toReturn=(E)this.head.element;
        this.head=this.head.next;
        size--;
        return toReturn;
    }

    @Override
    public E removeLast() {
        validate();
        E toReturn=(E)this.tail.element;
        Node<E> current=this.head;
     for(int i=0;i<size-2;i++){
         current=current.next;
     }
     size--;
     current.next=null;
     this.tail=current;
        return toReturn;
    }

    @Override
    public E getFirst() {
        return (E)this.head.element;
    }

    @Override
    public E getLast() {
        return (E)this.tail.element;
    }

    @Override
    public int size() {
        return this.size;
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
            Node<E> node=new Node(20,head);

            @Override
            public boolean hasNext() {
                return node.next!=null;
            }

            @Override
            public E next() {
                node=node.next;
                return (E)node.element;
            }
        };
    }
}
