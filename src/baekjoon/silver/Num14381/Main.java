package baekjoon.silver.Num14381;

import java.io.*;
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

            Set<Integer> set = new HashSet<>();
            int cur = N;
            for (int i = 1; i <= 200; i++, cur += N) {
                int temp = cur;
                while (temp > 0) {
                    set.add(temp % 10);
                    temp /= 10;
                }
                if (set.size() == 10) {
                    break;
                }
            }

            sb.append("Case #").append(t).append(": ").append(set.size() == 10 ? cur : "INSOMNIA").append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}