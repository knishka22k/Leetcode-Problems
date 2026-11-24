class Solution {
    public int maxLength(int[] nums) {
        int maxLen = 2;
        long maxLcm = 1;

        for(int num :nums){
            maxLcm = lcm(maxLcm , num);
        }

        for(int i=0; i<nums.length; i++){
            long prod = 1;
            long currGcd = 0;
            long currLcm = 1;

            for(int j=i; j<nums.length; j++){
                prod *= nums[j];
                currGcd = gcd( currGcd, nums[j]);
                currLcm = lcm( currLcm, nums[j]);

            if(prod == currLcm * currGcd){
                maxLen = Math.max(maxLen , j-i+1);
            }
        }
        }
        return maxLen;
    }
    private long gcd(long a, long b){
        while(b != 0){
            long temp = b;
            b = a % b;
            a = temp; 
        }
        return a;
    }

    private long lcm(long a, long b){
        return (a*b/gcd(a,b));
    }
}