import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class stringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list=new ArrayList<>();
        String command = scanner.nextLine();
        String regex="[0-9]+";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(command);
        matcher.find();
        int degrees=Integer.parseInt(matcher.group());
        degrees=degrees%360;
        int max=-1;
        while(true){
            String a = scanner.nextLine();
            if(a.equals("END")){
                break;
            }
            if(a.length()>max){
                max=a.length();
            }
            list.add(a);
        }
        String[][] arr=new String[list.size()][max];
        for(int i=0;i<list.size();i++){
            for(int k=0;k<max;k++){
                arr[i][k]=" ";

            }
        }
        for(int i=0;i<list.size();i++){
            for(int k=0;k<list.get(i).length();k++){
                arr[i][k]=Character.toString(list.get(i).charAt(k));
            }

        }
        if(degrees==0){
            for(String str:list){
                System.out.println(str);
            }
        }
        if(degrees==90) {
            r90(arr,0);
        }
        if(degrees==180) {
            r180(arr);
        }
        if(degrees==270) {
            r270(arr);
        }
    }
    public static void r180(String[][]arr){
        for(int i=arr.length-1;i>=0;i--){
            for(int k=arr[i].length-1;k>=0;k--){
                System.out.print(arr[i][k]);
            }
            System.out.println();
        }
    }

    public static String[][] r90(String[][]arr,int f){
        String[][] arr90=new String[arr[0].length][arr.length];
        int col=arr90[0].length-1;
        for(int i=0;i<arr.length;i++){
            String[] cur=new String[arr[0].length];
            for(int k=0;k<arr[0].length;k++){
                cur[k]=arr[i][k];
            }
            for(int y=0;y<arr90.length;y++){
                arr90[y][col]=cur[y];
            }
            col--;
        }
if(f==0) {
    for (int i = 0; i < arr90.length; i++) {
        for (int k = 0; k < arr90[0].length; k++) {
            System.out.print(arr90[i][k]);
        }
        System.out.println();
    }
}
        return arr90;
    }
    public static void r270(String[][]arr){
        r180(r90(arr,1));
    }
}
