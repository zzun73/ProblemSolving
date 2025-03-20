package programmers.level2.Num87946;

class Solution {
    static int answer;
    static boolean[] visited;

    void helper(int k, int[][] dungeons, int count) {
        answer = Math.max(count, answer);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                helper(k - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        answer = 0;
        helper(k, dungeons, 0);
        return answer;
    }
}