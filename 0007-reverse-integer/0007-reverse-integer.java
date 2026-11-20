class Solution {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int pop = x % 10; //isolating last digit so that we can use it 
            x /= 10; //remove last element
            // Check positive overflow before updating rev
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            
            // Check negative overflow before updating rev
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop; 
        }
        return rev;
    }
}