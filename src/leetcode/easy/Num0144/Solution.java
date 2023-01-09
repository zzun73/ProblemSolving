package leetcode.easy.Num0144;

import java.util.ArrayList;
import java.util.List;

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
    static List<Integer> answer;

    public List<Integer> preorderTraversal(TreeNode root) {
        answer = new ArrayList();
        helper(root);
        return answer;
    }

    public static void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        answer.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}
