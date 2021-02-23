package implementations;

public class TheMatrix {
    private char[][] matrix;
    private char fillChar;
    private char toBeReplaced;
    private int startRow;
    private int startCol;

    public TheMatrix(char[][] matrix, char fillChar, int startRow, int startCol) {
        this.matrix = matrix;
        this.fillChar = fillChar;
        this.startRow = startRow;
        this.startCol = startCol;
        this.toBeReplaced = this.matrix[this.startRow][this.startCol];
    }

    public void solve(int Row,int Col) {
        if(matrix[Row][Col]==toBeReplaced) {
            matrix[Row][Col] = fillChar;
        }
        if(validate(Row+1,Col)){
            if(matrix[Row+1][Col]==toBeReplaced){
                solve(Row+1,Col);
            }
        }
        if(validate(Row-1,Col)){
            if(matrix[Row-1][Col]==toBeReplaced){
                solve(Row-1,Col);
            }
        }
        if(validate(Row,Col+1)){
            if(matrix[Row][Col+1]==toBeReplaced){
                solve(Row,Col+1);
            }
        }
        if(validate(Row,Col-1)){
            if(matrix[Row][Col-1]==toBeReplaced){
                solve(Row,Col-1);
            }
        }



    }
    public boolean validate(int row,int col){
        return row>=0&&col>=0&&row<matrix.length&&col<matrix[0].length;
    }

    public String toOutputString() {
        // TODO: Implement
        StringBuilder build=new StringBuilder();
        for(int i=0;i<matrix.length;i++){
            for(int k=0;k<matrix[0].length;k++){
                build.append(matrix[i][k]);
            }
            if(i!=matrix.length-1) {
                build.append(System.lineSeparator());
            }
        }
        return build.toString();
    }
}
