import java.util.ArrayDeque;
import java.util.Scanner;

public class browserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cur=scanner.nextLine();
        String last="";
        ArrayDeque<String> stack=new ArrayDeque<>();
        ArrayDeque<String> stack2=new ArrayDeque<>();
        while(!cur.equals("Home")){

            if(cur.equals("back")){

                if(stack.isEmpty()){
                    System.out.println("no previous URLs");
                }
                else{
                    stack2.push(last);
                    last=stack.peek();
                    System.out.println(stack.pop());

                }


            }
            else if(cur.equals("forward")){
                if(stack2.isEmpty()){
                    System.out.println("no next URLs");
                }
                else{
                    stack.push(last);
                    last=stack2.peek();
                    System.out.println(stack2.pop());
                }

            }
            else{
                System.out.println(cur);
                if(!last.equals("")){
                    stack.push(last);}
                last=cur;
                stack2.clear();
            }



            cur=scanner.nextLine();
        }

    }
}
