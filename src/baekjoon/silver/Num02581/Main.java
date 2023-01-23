package baekjoon.silver.Num02581;

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

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        helper();

        int sum = 0, firstValue = -1;
        boolean checked = false;
        for (int i = M; i <= N; i++) {
            if (!visited[i]) {
                if (!checked) {
                    checked = true;
                    firstValue = i;
                }
                sum += i;
            }
        }

        if (sum == 0) {
            bw.write("-1");
        } else {
            bw.write(sum + "\n" + firstValue);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
