package baekjoon.bronze.Num02605;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            list.add(list.size() - idx, i);
        }
        for (int val : list) {
            sb.append(val).append(" ");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}