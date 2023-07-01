package leetcode.easy.Num1022;

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
        this.left = left;
        this.val = val;
        this.right = right;
    }
}

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int path) {

        if (root == null) {
            return 0;
        }

        path = (path << 1) + root.val;
        if (root.left == null && root.right == null) {
            return path;
        }

        int left = helper(root.left, path);
        int right = helper(root.right, path);
        return left + right;
    }
}