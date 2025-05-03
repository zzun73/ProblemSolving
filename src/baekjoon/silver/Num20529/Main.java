package baekjoon.silver.Num20529;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        while (N-- > 0) {
            set.add(br.readLine());
        }

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            if (set.contains(br.readLine())) {
                answer++;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}