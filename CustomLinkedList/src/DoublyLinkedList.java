public class DoublyLinkedList {
Node head;
Node tail;
int size;

    public class Node{
        int item;
        Node next;
        Node previous;

        public Node(int item) {
            this.item = item;
        }
    }

    public void addFirst(int element){
        Node node=new Node(element);
        if(size==0){
            head=node;
            tail=node;
            node.next=null;

        }
        else{
            node.next=this.head;
            this.head.previous=node;
            this.head=node;
        }
        node.previous=null;
        this.size++;

    }
    void addLast(int element){
        Node node=new Node(element);
        if(size==0){
            head=node;
            tail=node;
            node.previous=null;
        }
        else{
        node.previous=this.tail;
        this.tail.next=node;
        this.tail=node;
        }
        node.next=null;
        this.size++;
    }
    int get(int index){
        validateIndex(index);
        int br=0;
        Node current=this.head;
        while(br<index){
            current=current.next;
            br++;
        }

        return current.item;
    }
    void validateIndex(int index) {
        if (index < 0 || index>=size){
            throw new ArrayIndexOutOfBoundsException(index+" index is unexistent");
        }
    }

    int removeFirst(){
        int num=this.head.item;
        this.head=this.head.next;
        this.head.previous=null;
        this.size--;
        return num;
    }
    int removeLast(){
        int num=this.tail.item;
        this.tail=this.tail.previous;
        this.tail.next=null;
        this.size--;
        return num;
    }
    void forEach(){

        Node current=this.head;
        for(int i=0;i<this.size;i++){
            System.out.println(current.item);
            current=current.next;
        }

    }

    int[] toArray(){
        Node current=this.head;
        int[] arr=new int[this.size];
        for(int i=0;i<this.size;i++){
            arr[i]=current.item;
            current=current.next;
        }
        return arr;
    }
}
