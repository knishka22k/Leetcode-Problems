class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 1;
        }

        Set<Integer> pairs = new HashSet<>();
        Set<Integer> ans = new HashSet<>();

        // Step 1: Find XOR of every pair
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairs.add(nums[i] ^ nums[j]);
            }
        }

        // Step 2: Add third number
        for (int pair : pairs) {
            for (int num : nums) {
                ans.add(pair ^ num);
            }
        }

        return ans.size();
    }
}