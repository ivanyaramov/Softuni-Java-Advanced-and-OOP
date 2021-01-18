import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class crossFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] arrString=a.split(" ");
        List<List<Integer>> list=new ArrayList<>();
        int row=Integer.parseInt(arrString[0]);
        int col=Integer.parseInt(arrString[1]);
        for(int i=0;i<row;i++){
            List<Integer>cur=new ArrayList<>();
            for(int k=0;k<col;k++){
                cur.add(k+1+i*col);
            }
            list.add(cur);
        }
        while(true){
            String command = scanner.nextLine();
            if(command.equals("Nuke it from orbit")){
                break;
            }
            String[] splitCommand=command.split(" ");
            int rowCur=Integer.parseInt(splitCommand[0]);
            int colCur=Integer.parseInt(splitCommand[1]);
            int radius=Integer.parseInt(splitCommand[2]);
            for(int i=radius;i>=-radius;i--) {
                if (rowCur >= 0 && rowCur < list.size()) {
                    if (i + colCur < list.get(rowCur).size() && i + colCur >= 0) {
                        list.get(rowCur).remove(i + colCur);
                    }
                }
            }

            for(int i=radius;i>=-radius;i--){
                if(i+rowCur<list.size() && i+rowCur>=0){
                    if(colCur>=0 && colCur<list.get(i+rowCur).size()) {
                        if(i!=0) {
                            list.get(i+rowCur).remove(colCur);
                        }
                    }
                }
            }
            if (rowCur >= 0 && rowCur < list.size()) {
                if(list.get(rowCur).isEmpty()){
                    list.remove(rowCur);
                }
            }
        }

        for(int i=0;i<list.size();i++){
            for(int k=0;k<list.get(i).size();k++){
                System.out.print(list.get(i).get(k)+" ");
            }
            System.out.println();
        }
    }
}