package baekjoon.silver.Num16499;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            Arrays.sort(input);
            for (char c : input) {
                sb.append(c);
            }
            set.add(sb.toString());
            sb.setLength(0);
        }
        bw.write(String.valueOf(set.size()));

        br.close();
        bw.flush();
        bw.close();
    }
}