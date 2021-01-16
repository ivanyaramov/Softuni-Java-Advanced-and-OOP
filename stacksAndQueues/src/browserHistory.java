import java.util.ArrayDeque;
import java.util.Scanner;

public class browserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cur=scanner.nextLine();
        String last="";
        ArrayDeque<String> stack=new ArrayDeque<>();
        while(!cur.equals("Home")){

            if(cur.equals("back")){

if(stack.isEmpty()){
    System.out.println("no previous URLs");
}
       else{
           last=stack.peek();
    System.out.println(stack.pop());
}


            }
else{
                System.out.println(cur);
                if(!last.equals("")){
                stack.push(last);}
                last=cur;
            }



            cur=scanner.nextLine();
        }

    }
}
