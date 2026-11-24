class Solution {
    public int findGCD(int[] nums) {

        int minEle = Integer.MAX_VALUE;
        int maxEle = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){

            minEle = Math.min(minEle, nums[i]);
            maxEle = Math.max(maxEle, nums[i]);

        }
        return gcd(minEle, maxEle);
    }
    private int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp; 
        }
        return a;
    }
}