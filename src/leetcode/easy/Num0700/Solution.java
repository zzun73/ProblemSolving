package leetcode.easy.Num0700;


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
    TreeNode answer;

    public TreeNode searchBST(TreeNode root, int val) {
        answer = new TreeNode();
        helper(root, val);
        return answer;
    }

    public void helper(TreeNode root, int val) {
        if (root == null || root.val == val) {
            answer = root;
            return;
        }
        if (root.val > val) {
            helper(root.left, val);
        } else {
            helper(root.right, val);
        }
    }
}