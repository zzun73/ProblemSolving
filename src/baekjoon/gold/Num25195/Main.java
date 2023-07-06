package baekjoon.gold.Num25195;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> list;
    static boolean[] checked;
    static boolean flag;

    public static void helper(int start) {
        if (list.get(start).size() == 0) {
            flag = true;
            return;
        }
        for (int val : list.get(start)) {
            if (!checked[val]) {
                helper(val);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>(N + 1);
        checked = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
        }
        int S = Integer.parseInt(br.readLine());
        checked = new boolean[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < S; i++) {
            int val = Integer.parseInt(st.nextToken());
            checked[val] = true;
        }
        flag = false;
        if (!checked[1]) {
            helper(1);
        }
        bw.write(flag ? "yes" : "Yes");

        br.close();
        bw.flush();
        bw.close();
    }
}
