package leetcode.easy.Num0104;


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
    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(helper(root.left), helper(root.right));
    }
}
