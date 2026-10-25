class Solution {    
    public int countPrimes(int n) {
        if(n<2){
            return 0;
        }

        int isPrime[] = new int[n+1]; //making array for 1 and 0 filling
        Arrays.fill(isPrime, 0); //asume all are 0

        //0 and 1 are neither prime neither nonprime
        isPrime[0] = 0;
        isPrime[1] = 0;

        // Simple Sieve
        for(int i=2; i*i<=n; i++){
            if(isPrime[i] == 0){
                for(int j=i*i; j<=n; j+=i){ //this is for 2*2=4, 3*3=9.....
                    isPrime[j] = 1;
                }
            }
        }
        int count = 0; 
        for(int i=2; i<n; i++){
            if(isPrime[i] == 0){
                count++;
            }
        }
        return count;
    }
}