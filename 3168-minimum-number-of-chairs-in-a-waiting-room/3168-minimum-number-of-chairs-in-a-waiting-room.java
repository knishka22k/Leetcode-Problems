class Solution {
    public int minimumChairs(String s) {
        int max= 0;
        int count = 0;
        for (int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (ch == 'E'){
                count++;
            }
            else{
                max = Math.max(count, max);
                count--;
            }
        }
        max = Math.max(count, max);
        return max;
    }
}