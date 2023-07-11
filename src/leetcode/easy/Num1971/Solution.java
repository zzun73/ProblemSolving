package leetcode.easy.Num1971;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<List<Integer>> list;
    static boolean[] visited;

    public void helper(int start, int destination) {
        visited[start] = true;
        if (start == destination) {
            return;
        }
        for (int val : list.get(start)) {
            if (!visited[val]) {
                helper(val, destination);
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        list = new ArrayList<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        helper(source, destination);
        return visited[destination];
    }
}