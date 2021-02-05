import java.util.Scanner;

public class snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] arr = new String[n][n];
        int food=0;
        int indexRow=-1;
        int indexCol=-1;
        int indexRowFirst=-1;
        int indexRowSecond=-1;
        int indexColFirst=-1;
        int indexColSecond=-1;
        for(int i=0;i<n;i++){
            String[] curArray = scanner.nextLine().split("");
            arr[i]=curArray;
            for(int k=0;k<n;k++){
                if(arr[i][k].equals("S")){
                    indexRow=i;
                    indexCol=k;
                }
                if(arr[i][k].equals("B")){
                    if(indexColFirst>-1){
                        indexRowSecond=i;
                        indexColSecond=k;
                    }
                    else{
                        indexRowFirst=i;
                        indexColFirst=k;
                    }
                }
            }
        }
        arr[indexRow][indexCol]=".";
        boolean bool=true;
        String line=scanner.nextLine();
        while(true){
            if(line.equals("up")){
                indexRow--;
                if(!validateIndexes(indexRow,indexCol,n)){
                    bool=false;
                    break;
                }
                if(arr[indexRow][indexCol].equals("*")){
                    food++;
                    arr[indexRow][indexCol]=".";
                }
                if(arr[indexRow][indexCol].equals("-")){
                    arr[indexRow][indexCol]=".";
                }
                if(arr[indexRow][indexCol].equals("B")){
                    if(indexRow==indexRowFirst && indexCol==indexColFirst){
                        arr[indexRow][indexCol]=".";
                        indexRow=indexRowSecond;
                        indexCol=indexColSecond;
                        arr[indexRow][indexCol]=".";
                    }
                    else{
                        arr[indexRow][indexCol]=".";
                        indexRow=indexRowFirst;
                        indexCol=indexColFirst;
                        arr[indexRow][indexCol]=".";
                    }
                }
            }

            if(line.equals("down")){
                indexRow++;
                if(!validateIndexes(indexRow,indexCol,n)){
                    bool=false;
                    break;
                }
                if(arr[indexRow][indexCol].equals("*")){
                    food++;
                    arr[indexRow][indexCol]=".";
                }
                if(arr[indexRow][indexCol].equals("-")){
                    arr[indexRow][indexCol]=".";
                }
                if(arr[indexRow][indexCol].equals("B")){
                    if(indexRow==indexRowFirst && indexCol==indexColFirst){
                        arr[indexRow][indexCol]=".";
                        indexRow=indexRowSecond;
                        indexCol=indexColSecond;
                        arr[indexRow][indexCol]=".";
                    }
                    else{
                        arr[indexRow][indexCol]=".";
                        indexRow=indexRowFirst;
                        indexCol=indexColFirst;
                        arr[indexRow][indexCol]=".";
                    }
                }
            }
            if(line.equals("right")){
                indexCol++;
                if(!validateIndexes(indexRow,indexCol,n)){
                    bool=false;
                    break;
                }
                if(arr[indexRow][indexCol].equals("*")){
                    food++;
                    arr[indexRow][indexCol]=".";
                }
                if(arr[indexRow][indexCol].equals("-")){
                    arr[indexRow][indexCol]=".";
                }
                if(arr[indexRow][indexCol].equals("B")){
                    if(indexRow==indexRowFirst && indexCol==indexColFirst){
                        arr[indexRow][indexCol]=".";
                        indexRow=indexRowSecond;
                        indexCol=indexColSecond;
                        arr[indexRow][indexCol]=".";
                    }
                    else{
                        arr[indexRow][indexCol]=".";
                        indexRow=indexRowFirst;
                        indexCol=indexColFirst;
                        arr[indexRow][indexCol]=".";
                    }
                }
            }
            if(line.equals("left")){
                indexCol--;
                if(!validateIndexes(indexRow,indexCol,n)){
                    bool=false;
                    break;
                }
                if(arr[indexRow][indexCol].equals("*")){
                    food++;
                    arr[indexRow][indexCol]=".";
                }
                if(arr[indexRow][indexCol].equals("-")){
                    arr[indexRow][indexCol]=".";
                }
                if(arr[indexRow][indexCol].equals("B")){
                    if(indexRow==indexRowFirst && indexCol==indexColFirst){
                        arr[indexRow][indexCol]=".";
                        indexRow=indexRowSecond;
                        indexCol=indexColSecond;
                        arr[indexRow][indexCol]=".";
                    }
                    else{
                        arr[indexRow][indexCol]=".";
                        indexRow=indexRowFirst;
                        indexCol=indexColFirst;
                        arr[indexRow][indexCol]=".";
                    }
                }
            }
            if(food>=10){
                System.out.println("You won! You fed the snake.");
                arr[indexRow][indexCol]="S";
                break;
            }

            line=scanner.nextLine();
        }
        System.out.printf("Food eaten: %s%n",food);

        for(int i=0;i<n;i++){
            for(int k=0;k<n;k++){
                System.out.print(arr[i][k]);
            }
            System.out.println();
        }

    }
    public static boolean validateIndexes(int row,int col,int n){
        if(row<0||row>=n||col<0||col>=n){
            System.out.println("Game over!");
            return false;
        }
        return true;
    }
}