package baekjoon.bronze.Num13300;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[2][7];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            arr[gender][grade]++;
        }

        int answer = 0;
        for (int[] grade : arr) {
            for (int val : grade) {
                int temp = val / K;
                answer += temp;
                if (val % K != 0) {
                    answer += 1;
                }
            }
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
