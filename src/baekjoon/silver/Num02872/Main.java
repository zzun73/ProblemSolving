package baekjoon.silver.Num02872;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = N;
        for (int i = N - 1; i >= 0; i--) {
            if (answer == arr[i]) {
                answer--;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}