package baekjoon.silver.Num25916;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0, sum = 0, left = 0, right = 0;
        while (right < N) {

            if (sum + arr[right] <= M) {
                sum += arr[right++];
                answer = Math.max(answer, sum);
            } else {
                sum -= arr[left++];
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}