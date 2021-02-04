import java.util.Arrays;
import java.util.Scanner;

public class bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int indexes[]=new int[2];
        boolean bool=true;
        indexes[0]=-1;
        indexes[1]=-1;
        String[][] arr= new String[n][n];
        for(int i=0;i<n;i++) {
            String line = scanner.nextLine();
            String[] curArray = line.split("");
            for (int k = 0; k < n; k++) {
                if(curArray[k].equals("B")){
                    indexes[0]=i;
                    indexes[1]=k;
                }
                arr[i][k] = curArray[k];
            }
        }
            int[] pollinatedFlowers= new int[1];

        String line=scanner.nextLine();
        while(!line.equals("End")){
if(!operations(line,indexes,arr,pollinatedFlowers,n)){
    bool=false;
    break;
}
line=scanner.nextLine();
        }
        if(bool) {
            arr[indexes[0]][indexes[1]] = "B";
        }
        if(pollinatedFlowers[0]>=5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",pollinatedFlowers[0]);
        }
        else{
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",5-pollinatedFlowers[0]);
        }

       for(int i=0;i<n;i++){
           for(int k=0;k<n;k++){
               System.out.print(arr[i][k]);
           }
           System.out.println();
       }

    }
    public static boolean operations(String command,int[] indexes, String[][] arr,int[] pollinatedFlowers,int n){
        if(command.equals("up")){
            arr[indexes[0]][indexes[1]]=".";
            indexes[0]--;
        }
        if(command.equals("down")){
            arr[indexes[0]][indexes[1]]=".";
            indexes[0]++;
        }
        if(command.equals("right")){
            arr[indexes[0]][indexes[1]]=".";
            indexes[1]++;
        }
        if(command.equals("left")){
            arr[indexes[0]][indexes[1]]=".";
            indexes[1]--;
        }
        if(indexes[1]>=n || indexes[1]<0 || indexes[0]>=n || indexes[0]<0){
            System.out.println("The bee got lost!");
            return false;
        }
        if(arr[indexes[0]][indexes[1]].equals("O")){
            arr[indexes[0]][indexes[1]]=".";
            if(command.equals("up")){
                indexes[0]--;
            }
            if(command.equals("down")){
                indexes[0]++;
            }
            if(command.equals("right")){
                indexes[1]++;
            }
            if(command.equals("left")){
                indexes[1]--;
            }
        }
        if(indexes[1]>=n || indexes[1]<0 || indexes[0]>=n || indexes[0]<0){
            System.out.println("The bee got lost!");
            return false;
        }
       if(arr[indexes[0]][indexes[1]].equals("f")){
           pollinatedFlowers[0]++;
           arr[indexes[0]][indexes[1]]=".";
       }


return true;
    }
}
