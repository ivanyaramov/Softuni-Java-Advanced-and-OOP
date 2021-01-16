import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class matchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] arr=a.split(" ");
        ArrayDeque<Character> stack=new ArrayDeque<>();
        boolean bool=false;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)=='('){
                bool=true;
            }
            if(bool){
                stack.push(a.charAt(i));
                if(a.charAt(i)==')'){
                    int k=i;
                    List<Character> list=new ArrayList<>();
                    int br=0;
                    while(true){
                        if(a.charAt(k)==')'){
                            br++;
                        }
                        if(a.charAt(k)=='('){
                            br--;
                        }
                        list.add(a.charAt(k));
                        k--;
                        if(br==0){
                            for(int y=list.size()-1;y>=0;y--){


                                    System.out.print(list.get(y));

                            }
                            System.out.println();
                            break;
                        }
                    }
                }
            }
        }
    }
}
