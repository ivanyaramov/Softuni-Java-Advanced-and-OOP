import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String line=scanner.nextLine();
        String[] commands = line.split(",");
        int row=-1;
        int col=-1;
        int bombs=0;
        int bombsTotal=0;
        boolean bool=false;
        String[][] arr=new String[n][n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextLine().split(" ");
        }
        for(int i=0;i<n;i++){
            for(int k=0;k<n;k++){
                if(arr[i][k].equals("s")){
                    row=i;
                    col=k;
                }
                if(arr[i][k].equals("B")){
                    bombsTotal++;
                }
            }
        }
        for(String command:commands){
            if(command.equals("up")){
                row--;
                if(!validator(row,col,n)){
                    row++;
                }
            }
            if(command.equals("down")){
                row++;
                if(!validator(row,col,n)){
                    row--;
                }

            }
            if(command.equals("right")){
                col++;
                if(!validator(row,col,n)){
                    col--;
                }

            }
            if(command.equals("left")){
                col--;
                if(!validator(row,col,n)){
                    col++;
                }

            }
            if(arr[row][col].equals("e")){
                System.out.printf("END! %d bombs left on the field",bombsTotal-bombs);
           bool=true;
            break;
            }
            if(arr[row][col].equals("B")){
                System.out.println("You found a bomb!");
                arr[row][col]="+";
                bombs++;
            }
            if(bombs==bombsTotal){
                System.out.println("Congratulations! You found all bombs!");
                bool=true;
                break;
            }
        }
        if(!bool){
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",bombsTotal-bombs,row,col);
        }
    }
    public static boolean validator(int row, int col,int n){
        if(row>=n || col>=n || row<0 || col<0){
            return false;
        }
        return true;
    }
}
