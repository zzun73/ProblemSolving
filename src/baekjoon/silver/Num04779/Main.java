package baekjoon.silver.Num04779;

import java.io.*;

public class Main {
    static int N;
    static char[] path;
    static StringBuilder sb = new StringBuilder();

    static void helper(int depth, int start, int end) {
        if (depth == N) {
            return;
        }

        int size = (end - start) / 3;
        for (int i = start + size; i < start + size * 2; i++) {
            path[i] = ' ';
        }
        helper(depth + 1, start, start + size);
        helper(depth + 1, start + size * 2, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while ((str = br.readLine()) != null) {
            N = Integer.parseInt(str);
            path = "-".repeat((int) Math.pow(3, N)).toCharArray();
            helper(0, 0, path.length);

            for (char c : path) {
                sb.append(c);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}