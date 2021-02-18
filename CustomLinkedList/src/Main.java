public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list=new DoublyLinkedList();
        list.addFirst(2);
        list.addFirst(5);
        list.addLast(4);
        list.addLast(10);
        list.removeFirst();
        list.removeLast();
        int[] arr=list.toArray();
        list.forEach();
    }
}
