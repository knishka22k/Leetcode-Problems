class Solution {
    public String maxSumOfSquares(int num, int sum) {
         StringBuilder sb = new StringBuilder("");
        int k = 9;
        while (sum > 0 && sb.length() <num){
            if(k<=sum){
                sb.append(Integer.toString(k));
                sum -= k;
            }
            else{
                k--;
            }
        }
        
        if (sum !=0)
        return "";
        
        while (sb.length() < num){
            sb.append("0");
        }
        
        return sb.toString();
    }
}