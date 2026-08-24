class Solution {
    public int tribonacci(int n){
        int t[] = new int[n+1];
        Arrays.fill(t, -1);

        return tribonacciMemo(n, t);
    }
    public int tribonacciMemo(int n, int t[]) {
        //base case
        if(n==0 || n==1){
            return n;
        }
        if(n==2){
            return 1;
        }
        //already appeared 
        if(t[n] != -1){
            return t[n];
        }
        //recursion
        t[n] = tribonacciMemo(n-1, t) + tribonacciMemo(n-2, t) + tribonacciMemo(n-3, t);
        return t[n];
    }
}