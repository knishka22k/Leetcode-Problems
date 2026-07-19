class Solution {

    static class Info {
        int dia;
        int ht;

        Info(int dia, int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).dia;
    }

    private Info diameter(TreeNode root) {

        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int height = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        int diameter = Math.max(leftInfo.ht + rightInfo.ht, Math.max(leftInfo.dia, rightInfo.dia));

        return new Info(diameter, height);
    }
}