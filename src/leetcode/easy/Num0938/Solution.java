package leetcode.easy.Num0938;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    static int L, H;

    public int rangeSumBST(TreeNode root, int low, int high) {
        L = low;
        H = high;
        return helper(root);
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.val < L) {
            return helper(root.right);
        } else if (root.val > H) {
            return helper(root.left);
        }

        return root.val + helper(root.right) + helper(root.left);

    }
}