package swea.d3.Num06913;

import java.io.*;
import java.util.Arrays;
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
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    arr[i] += Integer.parseInt(st.nextToken());
                }
            }
            Arrays.sort(arr);
            int count = 0, max = arr[N - 1];
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] == arr[N - 1]) {
                    count++;
                } else {
                    break;
                }
            }
            sb.append("#").append(t).append(" ").append(count).append(" ").append(max).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}