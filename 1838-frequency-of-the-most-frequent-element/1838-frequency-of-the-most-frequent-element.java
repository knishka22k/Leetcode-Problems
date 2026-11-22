class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        long currSum = 0;
        for(int right = 0; right<nums.length; right++){
            currSum += nums[right];

            if((long)(right - left + 1) * nums[right] - currSum > k){
                currSum -= nums[left];
                left++;
            }
        }
        return nums.length - left;
    }
}