class Solution {

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] sortedNums = new int[n];
        int[] indexMap = new int[n];

        for (int i = 0; i < n; i++) {
            sortedNums[i] = arr[i][0];
            indexMap[arr[i][1]] = i;
        }

        int LOG = 18;
        while ((1 << LOG) <= n) LOG++;

        int[][] jump = new int[n][LOG];

        int r = 0;

        for (int i = 0; i < n; i++) {

            while (r + 1 < n && sortedNums[r + 1] - sortedNums[i] <= maxDiff)
                r++;

            jump[i][0] = r;
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                jump[i][j] = jump[jump[i][j - 1]][j - 1];
            }
        }

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int u = indexMap[queries[q][0]];
            int v = indexMap[queries[q][1]];

            if (u > v) {
                int t = u;
                u = v;
                v = t;
            }

            if (u == v) {
                ans[q] = 0;
                continue;
            }

            if (jump[u][LOG - 1] < v) {
                ans[q] = -1;
                continue;
            }

            int steps = 0;

            for (int j = LOG - 1; j >= 0; j--) {
                if (jump[u][j] < v) {
                    steps += 1 << j;
                    u = jump[u][j];
                }
            }

            ans[q] = steps + 1;
        }

        return ans;
    }
}