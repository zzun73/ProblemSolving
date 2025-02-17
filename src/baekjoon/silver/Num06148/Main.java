package baekjoon.silver.Num06148;

import java.util.StringTokenizer;
import java.io.*;

public class Main {
    static int N, B, answer;
    static int[] arr;

    static void helper(int idx, int sum) {

        if (idx == N ) {
            if(sum>=B) {
                answer = Math.min(Math.abs(B - sum), answer);
            }
            return;
        }

        helper(idx + 1, sum + arr[idx]);
        helper(idx + 1, sum);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        answer = Integer.MAX_VALUE;
        helper(0, 0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}