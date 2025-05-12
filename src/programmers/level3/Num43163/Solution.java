package programmers.level3.Num43163;

class Solution {
    static int answer;

    static boolean canChange(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    static void helper(int depth, String cur, String target, String[] words, boolean[] visited) {
        if (cur.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && canChange(cur, words[i])) {
                visited[i] = true;
                helper(depth + 1, words[i], target, words, visited);
                visited[i] = false;
            }
        }
    }

    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        helper(0, begin, target, words, new boolean[words.length]);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}