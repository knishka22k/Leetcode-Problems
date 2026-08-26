class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int maxAmt = 0;
        int dp[] = new int[n];

        //base case
        if(n == 1){
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        for(int i=2; i<n; i++){
            int rob = nums[i] + dp[i-2];
            int dontRob = dp[i-1];
            dp[i] = Math.max(rob, dontRob);
        }
        return dp[n-1];
    }
}