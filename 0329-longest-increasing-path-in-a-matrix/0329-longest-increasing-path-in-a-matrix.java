class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans = Math.max(ans , dfs(matrix, i, j, dp));
            }
        }
        return ans;
    }

    public int dfs(int matrix[][], int i, int j, int dp[][]){

        int n = matrix.length;
        int m = matrix[0].length;

        //already calculated
        if(dp[i][j] != 0){
            return dp[i][j];
        }

        // current cell itself
        dp[i][j] = 1;
        
        //bottom up
        //up
        if(i-1 >= 0 && matrix[i-1][j] > matrix[i][j]){
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(matrix, i-1, j, dp));
        }
        //down
        if(i+1 < n && matrix[i+1][j] > matrix[i][j]){
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(matrix, i+1, j, dp));
        }
        //left
        if(j-1 >= 0 && matrix[i][j-1] > matrix[i][j]){
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(matrix, i, j-1, dp));
        }
        //right
        if(j+1 < m && matrix[i][j+1] > matrix[i][j]){
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(matrix, i, j+1, dp));
        }
        return dp[i][j];
    }
}