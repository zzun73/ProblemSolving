package baekjoon.gold.Num02212;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            list.add(cur);
        }
        Collections.sort(list);

        List<Integer> gap = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            gap.add(list.get(i + 1) - list.get(i));
            sum += gap.get(i);
        }
        Collections.sort(gap);

        int count = 0;
        for (int i = gap.size() - 1; i >= 0 && count < K - 1; i--, count++) {
            sum -= gap.get(i);
        }

        bw.write(String.valueOf(sum));

        br.close();
        bw.close();
    }
}