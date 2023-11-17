package baekjoon.silver.Num05671;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String str = "";
        while ((str = br.readLine())!=null) {
            st = new StringTokenizer(str, " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            HashSet<Integer> set = new HashSet<>();
            int answer = 0;
            boolean flag;

            while (N <= M) {
                int cur = N++;
                flag = true;
                set.clear();
                while (cur > 0) {
                    if (!set.add(cur % 10)) {
                        flag = false;
                        break;
                    }
                    cur /= 10;
                }
                if (flag) {
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}