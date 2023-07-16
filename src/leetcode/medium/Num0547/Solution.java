package leetcode.medium.Num0547;

class Solution {
    public void helper(int start, int[][] isConnected, boolean[] visited) {
        visited[start] = true;
        for (int i = 0; i < isConnected[start].length; i++) {
            if (!visited[i] && isConnected[start][i] == 1) {
                helper(i, isConnected, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int answer = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                helper(i, isConnected, visited);
                answer++;
            }
        }

        return answer;
    }
}