class NumArray {

    int tree[];
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];

        buildST(nums, 0, 0, n - 1);

    }

    public void buildST(int arr[], int i, int start, int end) {

        if (start == end) {
            tree[i] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        buildST(arr, 2 * i + 1, start, mid);
        buildST(arr, 2 * i + 2, mid + 1, end);

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }
    
    public void update(int index, int val) {
        updateUtil(0, 0, n - 1, index, val);
    }

    public void updateUtil(int i, int start, int end, int index, int val) {

        if (start == end) {
            tree[i] = val;
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            updateUtil(2 * i + 1, start, mid, index, val);
        } else {
            updateUtil(2 * i + 2, mid + 1, end, index, val);
        }

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }
    
    public int sumRange(int left, int right) {
        return getSumUtil(0, 0, n - 1, left, right);
    }

    public int getSumUtil(int i, int start, int end, int qi, int qj) {

        // No overlap
        if (qj < start || qi > end) {
            return 0;
        }

        // Complete overlap
        if (qi <= start && end <= qj) {
            return tree[i];
        }

        // Partial overlap
        int mid = (start + end) / 2;

        int left = getSumUtil(2 * i + 1, start, mid, qi, qj);
        int right = getSumUtil(2 * i + 2, mid + 1, end, qi, qj);

        return left + right;
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */