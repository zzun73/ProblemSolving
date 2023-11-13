package swea.d3.Num01206;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 4];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 2; i < N + 2; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            for (int i = 2; i < N + 2; i++) {
                int max = Math.max(Math.max(arr[i - 1], arr[i - 2]), Math.max(arr[i + 1], arr[i + 2]));
                if (arr[i] - max > 0) {
                    answer += arr[i] - max;
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}