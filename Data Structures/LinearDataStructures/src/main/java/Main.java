import implementations.SinglyLinkedList;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list=new SinglyLinkedList<>();
        list.addFirst(2);
        list.addLast(1);
        list.addFirst(1);
        System.out.println(list.removeLast());
        System.out.println(list.getLast());
        System.out.println(list.removeFirst());
        list.getFirst();
        System.out.println();
        Consumer<Integer> cons=p-> System.out.println(p);
        list.forEach(cons);



    }
}
