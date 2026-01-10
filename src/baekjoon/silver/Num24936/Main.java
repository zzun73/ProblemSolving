package baekjoon.silver.Num24936;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            sum += val;
            set.add(val);
        }

        Set<Integer> answer = new TreeSet<>();
        for (int val : set) {
            answer.add(sum - val);
        }

        sb.append(answer.size()).append("\n");
        for (int ans : answer) {
            sb.append(ans).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}