class Solution {
    public int missingNumber(int[] nums) {
        boolean arr[] = new boolean[nums.length+1];

        for(int i=0; i<nums.length; i++){
            arr[nums[i]] = true;
        }

        for(int j=0; j<=nums.length; j++){
            if(!arr[j]){
                return j;
            }
        }
        return -1;
    }
}