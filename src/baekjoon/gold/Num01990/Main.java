package baekjoon.gold.Num01990;

import java.io.*;
import java.util.StringTokenizer;

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
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        visited = new boolean[b + 1];
        helper();

        boolean checked;
        for (int i = a; i <= b; i++) {
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
                    bw.write(i + "\n");
                }
            }
        }
        bw.write("-1");

        br.close();
        bw.flush();
        bw.close();
    }
}
