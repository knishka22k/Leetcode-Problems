class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        // 1. Sort logs by timestamp ascending
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        // 2. Pair queries with their original indices and sort by query time
        int qLen = queries.length;
        int[][] sortedQueries = new int[qLen][2];
        for (int i = 0; i < qLen; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[qLen];
        int[] serverCount = new int[n + 1]; // 1-indexed server IDs
        int activeServers = 0;
        int left = 0, right = 0;

        // 3. Process each query using a sliding window
        for (int[] query : sortedQueries) {
            int qTime = query[0];
            int originalIdx = query[1];
            int startTime = qTime - x;

            // Expand right pointer: include logs with time <= qTime
            while (right < logs.length && logs[right][1] <= qTime) {
                int serverId = logs[right][0];
                if (serverCount[serverId] == 0) {
                    activeServers++;
                }
                serverCount[serverId]++;
                right++;
            }

            // Shrink left pointer: exclude logs with time < qTime - x
            while (left < logs.length && logs[left][1] < startTime) {
                int serverId = logs[left][0];
                serverCount[serverId]--;
                if (serverCount[serverId] == 0) {
                    activeServers--;
                }
                left++;
            }

            // Total servers minus active servers = zero-request servers
            ans[originalIdx] = n - activeServers;
        }

        return ans;
    }
}