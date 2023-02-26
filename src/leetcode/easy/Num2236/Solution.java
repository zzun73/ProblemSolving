package leetcode.easy.Num2236;


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
    public boolean checkTree(TreeNode root) {
        return helper(root);
    }

    public boolean helper(TreeNode root) {
        return root.val == (root.left.val + root.right.val);
    }
}