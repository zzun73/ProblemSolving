package baekjoon.silver.Num24385;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static List<Character> list;
    static boolean[] visited;
    static char[] input;

    static void helper(int count) {
        if (count == N) {
            for (char ch : list) {
                sb.append(ch);
            }
            sb.append("\n");
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                list.add(input[i]);
                visited[i] = true;
                helper(count + 1);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input = br.readLine().toCharArray();
        Arrays.sort(input);
        N = input.length;
        visited = new boolean[N];
        list = new ArrayList<>();
        helper(0);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}