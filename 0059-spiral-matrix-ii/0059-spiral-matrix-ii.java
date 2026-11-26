class Solution {
    public int[][] generateMatrix(int n) {
        int startRow = 0;
        int endRow = n-1;
        int startCol = 0;
        int endCol = n-1;
        int num = 1;

        int res[][] = new int[n][n];

        while(startRow <= endRow && startCol <= endCol){
            //top (Row)
            for(int j=startCol; j<=endCol; j++){
                res[startRow][j] = num++;
            }
            startRow++;
            //right (Col)
            for(int i=startRow; i<=endRow; i++){
                res[i][endCol] = num++;
            }
            endCol--;
            //bottom (row)
            for(int j=endCol; j>=startCol; j--){
                res[endRow][j] = num++;
            }
            endRow--;
            //left (Col)
            for(int i=endRow; i>=startRow; i--){
                res[i][startCol] = num++;
            }
            startCol++;
        }
        return res;
    }
}