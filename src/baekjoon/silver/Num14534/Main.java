package baekjoon.silver.Num14534;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static List<String> path;

    public static void helper(String str, int depth, int length) {
        if (depth == length) {
            for (String s : path) {
                sb.append(s);
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(str.charAt(i) + "");
                helper(str, depth + 1, length);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] str = new String[T];
        for (int i = 0; i < T; i++) {
            str[i] = br.readLine();
        }

        for (int i = 0; i < T; i++) {
            visited = new boolean[str[i].length()];
            path = new ArrayList<>();

            sb.append("Case # ").append(i + 1).append(":").append("\n");
            helper(str[i], 0, str[i].length());
            bw.write(sb + "");
            sb.setLength(0);

        }
        br.close();
        bw.flush();
        bw.close();
    }
}
