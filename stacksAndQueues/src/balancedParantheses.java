import java.util.ArrayDeque;
import java.util.Scanner;

public class balancedParantheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        ArrayDeque<Character>stack=new ArrayDeque<>();
        boolean flag=true;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)=='('||a.charAt(i)=='{'||a.charAt(i)=='['){
                stack.push(a.charAt(i));
            }
            else{
                if(stack.isEmpty()){
                    flag=false;
                    break;
                }
                if((int)stack.peek()==(int)a.charAt(i)-1 || (int)stack.peek()==(int)a.charAt(i)-2){
                    stack.pop();
                }
                else{
                    flag=false;{
                        break;
                    }
                }
            }
        }
        if(stack.isEmpty()&&flag){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
