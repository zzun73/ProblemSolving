package baekjoon.silver.Num08975;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int count = Math.round((float) N / 2);
        int answer = 0;

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String cur = br.readLine();
            if (set.contains(cur)) {
                set.remove(cur);
                if (--count == 0) {
                    answer = i + 1;
                    break;
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}