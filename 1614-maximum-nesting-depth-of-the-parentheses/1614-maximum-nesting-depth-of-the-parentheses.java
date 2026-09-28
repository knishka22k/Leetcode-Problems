class Solution {
    public int maxDepth(String s) {
         int count= 0, max = 0;
        for (int i = 0; i<s.length(); i++){
            char ch= s.charAt(i);
            
            if (ch == '(')
            count++;
            
            if (ch== ')'){
                max = Math.max(count, max);
                count--;
            }
        }
        return max;
    }
}