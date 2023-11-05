package baekjoon.silver.Num11256;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[i] = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int sum = 0;
            int answer = 0;
            for (int i = N - 1; i >= 0; i--) {
                sum += arr[i];
                answer++;
                if (sum >= J) {
                    break;
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