package leetcode.medium.Num1305;

import java.util.ArrayList;
import java.util.Collections;
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
    List<Integer> answer;

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        answer = new ArrayList<>();
        helper(root1);
        helper(root2);
        Collections.sort(answer);
        return answer;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        helper(root.right);
        answer.add(root.val);
    }
}