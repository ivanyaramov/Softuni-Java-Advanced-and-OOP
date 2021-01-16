import java.util.ArrayDeque;
import java.util.Scanner;

public class simpleCalculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        String a = scanner.nextLine();
        String[]arr=a.split(" ");

        for(int i=0;i<arr.length;i++){

          if(i==0){
              stack.push(Integer.parseInt(arr[i]));
          }
          if(i%2==1){
              if(arr[i].equals("+")){
                  stack.push(stack.peek()+Integer.parseInt(arr[i+1]));
              }
              else{
                  stack.push(stack.peek()-Integer.parseInt(arr[i+1]));
              }
              i++;
          }
        }

        System.out.println(stack.peek());

    }
}