class Solution {

    int n;
    List<int[]>[] graph;
    long k;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        this.k = k;
        this.n = online.length;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int left = Integer.MAX_VALUE;
        int right = 0;

        // Build graph (ignore offline nodes)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            if (!online[u] || !online[v]) continue;

            graph[u].add(new int[]{v, cost});

            left = Math.min(left, cost);
            right = Math.max(right, cost);
        }

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return check(left) ? left : -1;
    }

    private boolean check(int minEdgeCost) {

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            long cost = curr[0];
            int node = (int) curr[1];

            if (cost > k) return false;

            if (node == n - 1) return true;

            if (cost > dist[node]) continue;

            for (int[] next : graph[node]) {

                int neighbour = next[0];
                int edgeCost = next[1];

                if (edgeCost < minEdgeCost) continue;

                long newCost = cost + edgeCost;

                if (newCost < dist[neighbour]) {
                    dist[neighbour] = newCost;
                    pq.offer(new long[]{newCost, neighbour});
                }
            }
        }

        return false;
    }
}