package leetcode.medium.Num1302;

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
    static int maxDepth;
    static int answer;

    public int deepestLeavesSum(TreeNode root) {
        maxDepth = -1;
        answer = 0;
        find(root, 0);
        calc(root, 0);
        return answer;
    }

    public void find(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        maxDepth = Math.max(depth, maxDepth);
        find(root.left, depth + 1);
        find(root.right, depth + 1);

    }

    public void calc(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == maxDepth) {
            answer += root.val;
        }
        calc(root.left, depth + 1);
        calc(root.right, depth + 1);

    }
}