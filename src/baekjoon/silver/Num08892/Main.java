package baekjoon.silver.Num08892;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringBuilder path = new StringBuilder();
        StringBuilder cur = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] input = new String[N];
            for (int i = 0; i < N; i++) {
                input[i] = br.readLine();
            }

            boolean flag = false;
            path.setLength(0);
            for (int i = 0; i < N; i++) {
                if (flag) {
                    break;
                }
                for (int j = 0; j < N; j++) {
                    if (i != j) {
                        cur.append(input[i]).append(input[j]);
                        if (cur.toString().equals(cur.reverse().toString())) {
                            path.append(cur);
                            flag = true;
                            break;
                        }
                    }
                    cur.setLength(0);
                }
            }
            if (path.length() == 0) {
                path.append("0");
            }
            sb.append(path).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}