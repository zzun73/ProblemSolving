package baekjoon.silver.Num02992;

import java.io.*;

public class Main {
    static String str;
    static int answer, size, original;
    static boolean[] visited;

    public static void helper(int depth, StringBuilder sb) {
        if (depth == size) {
            int value = Integer.parseInt(sb.toString());
            if (original < value) {
                answer = Math.min(answer, value);
            }
        }

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(str.charAt(i));
                helper(depth + 1, sb);
                sb.setLength(sb.length() - 1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();
        answer = Integer.MAX_VALUE;
        visited = new boolean[str.length()];
        size = str.length();
        original = Integer.parseInt(str);
        helper(0, new StringBuilder());

        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? 0 : answer));
        br.close();
        bw.flush();
        bw.close();
    }
}
