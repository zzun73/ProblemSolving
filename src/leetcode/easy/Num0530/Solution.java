package leetcode.easy.Num0530;

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
    static int answer;
    static TreeNode parent;

    public int getMinimumDifference(TreeNode root) {
        answer = Integer.MAX_VALUE;
        parent = null;
        helper(root);

        return answer;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (parent != null) {
            answer = Math.min(answer, root.val - parent.val);
        }
        parent = root;
        helper(root.right);
    }
}