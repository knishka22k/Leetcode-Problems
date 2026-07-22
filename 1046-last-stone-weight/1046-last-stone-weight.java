class Solution {
    public int lastStoneWeight(int[] stones) {
         // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the heap
        for (int stone : stones) {
            pq.offer(stone);
        }

        // Keep smashing until at most one stone remains
        while (pq.size() > 1) {

            int first = pq.poll();   // Largest stone
            int second = pq.poll();  // Second largest stone

            if (first != second) {
                pq.offer(first - second);
            }
        }

        // If heap is empty return 0, otherwise return remaining stone
        return pq.isEmpty() ? 0 : pq.peek();
    }
}