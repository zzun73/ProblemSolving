package baekjoon.silver.Num10689;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");

            Set<String> all = new HashSet<>(Arrays.asList(str));
            Set<String> now = new HashSet<>();

            int answer = 0;
            for (int i = 0; i < N; i++) {
                now.add(str[i]);
                if (now.size() == all.size()) {
                    answer = i + 1;
                    break;
                }
            }

            sb.append("Case ").append(t).append(": ").append(answer).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}