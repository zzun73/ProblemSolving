package leetcode.easy.Num0257;

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
    List<String> answer;

    public List<String> binaryTreePaths(TreeNode root) {
        answer = new ArrayList<>();
        if (root != null) {
            helper(root, new StringBuilder());
        }
        return answer;
    }

    public void helper(TreeNode root, StringBuilder path) {
        path.append(root.val);
        if (root.left == null && root.right == null) {
            answer.add(path.toString());
            return;
        }
        path.append("->");
        if (root.left != null) {
            helper(root.left, new StringBuilder(path));
        }
        if (root.right != null) {
            helper(root.right, new StringBuilder(path));
        }
    }
}