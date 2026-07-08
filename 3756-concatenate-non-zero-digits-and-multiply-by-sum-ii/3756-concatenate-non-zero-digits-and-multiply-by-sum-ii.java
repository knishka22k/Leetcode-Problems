class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] pow10 = new long[n + 1];
        pow10[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // Prefix sum of digits
        int[] prefixSum = new int[n + 1];

        // Prefix count of non-zero digits
        int[] prefixCount = new int[n + 1];

        // Prefix value formed by concatenating non-zero digits
        long[] prefixValue = new long[n + 1];

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';

            prefixSum[i + 1] = prefixSum[i] + digit;
            prefixCount[i + 1] = prefixCount[i];
            prefixValue[i + 1] = prefixValue[i];

            if (digit != 0) {
                prefixCount[i + 1]++;
                prefixValue[i + 1] = (prefixValue[i] * 10 + digit) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int digitSum = prefixSum[r + 1] - prefixSum[l];

            int nonZeroDigits = prefixCount[r + 1] - prefixCount[l];

            long x = (prefixValue[r + 1]
                    - (prefixValue[l] * pow10[nonZeroDigits]) % MOD
                    + MOD) % MOD;

            ans[i] = (int) ((x * digitSum) % MOD);
        }

        return ans;
    }
}