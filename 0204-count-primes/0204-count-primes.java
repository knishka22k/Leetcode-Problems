class Solution {
    public int countPrimes(int n) {
        if(n < 2){
           return 0;
        }
        int isPrime[] = new int[n];
        
        for(int i = 2; i<n; i++){
            isPrime[i] = 1;
        }

        for(int i = 2; i*i < n; i++){
            if(isPrime[i] == 1){
                for(int j = i*i; j<n; j +=i){
                    isPrime[j] = 0;
                }
            }
        }

        int count = 0;
        for(int i =2; i<n; i++){
            if(isPrime[i] == 1){
               count++;
            }   
        }

        return count;
    }
}