package baekjoon.bronze.Num15059;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] arr = new int[2][3];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            arr[i][0] = A;
            arr[i][1] = B;
            arr[i][2] = C;
        }
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            int cur = arr[1][i] - arr[0][i];
            if (cur > 0) {
                answer += cur;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}