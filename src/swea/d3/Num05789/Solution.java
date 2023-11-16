package swea.d3.Num05789;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for (int i = 1; i <= Q; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int L = Integer.parseInt(st.nextToken()) - 1;
                int R = Integer.parseInt(st.nextToken()) - 1;

                while (L <= R) {
                    arr[L++] = i;
                }

            }
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}