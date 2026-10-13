class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i<nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        }
        
        Arrays.sort(nums);
        int n = nums.length;
        long sum = 0;
        int j= 0;
            for (; j<n/2; j++){
                sum -= nums[j]*nums[j];
            }
            for (; j<n; j++){
                sum += nums[j]*nums[j];
            }
        return sum;
    }
}