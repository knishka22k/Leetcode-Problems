class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int dp[][] = new int[n][2];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return maxProfitMemo(prices, fee, 0, 1, dp);
    }
    public int maxProfitMemo(int prices[], int fee, int i, int buy, int dp[][]){
        //base case
        if(i == prices.length){
            return 0;
        }
        //already visited
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        //top down
        int ans;
        if(buy == 1 ){
            //buy
            int buyStock = -prices[i] + maxProfitMemo(prices, fee, i+1, 0, dp);
            //dont buy
            int skip = maxProfitMemo(prices, fee, i+1, 1, dp);
            ans = Math.max(buyStock, skip);
        } else {
            //sell
            int sellStock = prices[i] - fee + maxProfitMemo(prices, fee, i+1, 1, dp);
            //dont sell
            int skip = maxProfitMemo(prices, fee, i+1, 0, dp);
            ans = Math.max(sellStock, skip);
        }
        dp[i][buy] = ans;
        return ans;
    }
}