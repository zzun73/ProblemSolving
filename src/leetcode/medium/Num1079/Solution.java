package leetcode.medium.Num1079;

import java.util.HashSet;

class Solution {
    static HashSet<String> set;
    static boolean[] visited;
    static int length;
    static String str;

    public int numTilePossibilities(String tiles) {
        set = new HashSet();
        visited = new boolean[tiles.length()];
        length = tiles.length();
        str = tiles;
        for (int i = 0; i < length; i++) {
            helper(i, new StringBuilder());
        }
        return set.size();
    }

    public static void helper(int depth, StringBuilder sb) {
        if (depth == length) {
            set.add(sb.toString());
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(str.charAt(i));
                helper(depth + 1, sb);
                sb.setLength(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}

