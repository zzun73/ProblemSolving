package swea.d3.Num01860;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static final String YES = "Possible";
    static final String NO = "Impossible";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int bread = 0, idx = 0, last = arr[N - 1];
            boolean flag = true;

            if (arr[0] == 0) {
                flag = false;
            } else {
                for (int time = 1; time <= last; time++) {
                    if (time % M == 0) {
                        bread += K;
                    }

                    if (idx < N) {
                        if (arr[idx] == time) {
                            if (bread-- > 0) {
                                idx++;
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(flag ? YES : NO).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}