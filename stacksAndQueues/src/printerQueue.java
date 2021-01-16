import java.util.ArrayDeque;
import java.util.Scanner;

public class printerQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue=new ArrayDeque<>();
        while(true){
            String a = scanner.nextLine();
            if(a.equals("print")){
                while(!queue.isEmpty()){
                    System.out.println(queue.poll());
                }
                break;
            }
            if(a.equals("cancel")){
                if(queue.isEmpty()){
                    System.out.println("Printer is on standby");
                }
                else {
                    System.out.print("Canceled ");
                    System.out.println(queue.poll());
                }
            }
            else{
                queue.offer(a);
            }
        }
    }
}
