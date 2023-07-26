package baekjoon.silver.Num01991;

import java.io.*;
import java.util.*;

class Node {
    Node left;
    char val;
    Node right;

    public Node(char val) {
        this.val = val;
        left = right = null;
    }
}

public class Main {
    static Node root = new Node('A');
    static StringBuilder sb = new StringBuilder();

    private static void insertNode(Node node, char val, char left, char right) {
        if (node.val == val) {
            node.left = left == '.' ? null : new Node(left);
            node.right = right == '.' ? null : new Node(right);
        } else {
            if (node.left != null) {
                insertNode(node.left, val, left, right);
            }
            if (node.right != null) {
                insertNode(node.right, val, left, right);
            }
        }
    }

    private static void preorder(Node node) {
        if (node == null) {
            return;
        }
        sb.append(node.val);
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        sb.append(node.val);
        inorder(node.right);
    }

    private static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        sb.append(node.val);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char val = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertNode(root, val, left, right);
        }

        preorder(root);
        sb.append("\n");
        inorder(root);
        sb.append("\n");
        postorder(root);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();

    }
}
