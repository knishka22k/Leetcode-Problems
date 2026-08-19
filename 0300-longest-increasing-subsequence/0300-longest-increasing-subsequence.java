class Solution {
    public static int lcs(int nums[], int nums1[]){
        int n = nums.length;
        int m = nums1.length;

        int dp[][] = new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(nums[i-1] == nums1[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int nums1[] = new int[set.size()];
        int i = 0;
        for(int num : set){
            nums1[i] = num;
            i++;
        }
        Arrays.sort(nums1);
        return lcs(nums, nums1);
    }
}