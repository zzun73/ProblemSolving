package baekjoon.silver.Num01747;

import java.io.*;

public class Main {
    static boolean[] visited;

    public static void helper() {
        visited[1] = true;
        for (int i = 2; i < Math.sqrt(visited.length); i++) {
            if (visited[i]) {
                continue;
            }
            for (int j = i * i; j < visited.length; j += i) {
                visited[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        visited = new boolean[1003002];
        helper();

        boolean checked;
        for (int i = N; i < visited.length; i++) {
            if (!visited[i]) {
                checked = false;
                String s = String.valueOf(i);
                for (int j = 0; j < s.length() / 2; j++) {
                    if (s.charAt(j) != s.charAt(s.length() - j - 1)) {
                        checked = true;
                        break;
                    }
                }

                if (!checked) {
                    bw.write(i + "");
                    break;
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
