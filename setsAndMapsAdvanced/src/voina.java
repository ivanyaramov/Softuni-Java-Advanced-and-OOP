import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> player1=new LinkedHashSet<>();
        Set<Integer> player2=new LinkedHashSet<>();
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        String[] stringP1= a.split(" ");
        String[] stringP2= b.split(" ");
        for(int i=0;i<stringP1.length;i++){
            player1.add(Integer.parseInt(stringP1[i]));

        }
        for(int i=0;i<stringP2.length;i++){

            player2.add(Integer.parseInt(stringP2[i]));
        }
        int br=0;
        while(true){
            br++;
            if(br>50){
                if(player1.size()>player2.size()){
                    System.out.println("First player win!");
                }
                else if(player1.size()<player2.size()){
                    System.out.println("Second player win!");
                }
                else {
                    System.out.println("Draw!");
                }
                break;
            }
            if(player1.isEmpty()){
                System.out.println("Second player win!");
                break;
            }
            if(player2.isEmpty()){
                System.out.println("First player win!");
                break;
            }
            int first1=player1.iterator().next();
            int first2=player2.iterator().next();
            player1.remove(first1);
            player2.remove(first2);
            if(first1>first2){
                player1.add(first1);
                player1.add(first2);
            }
            else if(first1<first2){
                player2.add(first1);
                player2.add(first2);
            }

            

        }
    }
}
