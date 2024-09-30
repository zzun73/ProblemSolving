package baekjoon.silver.Num12845;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];
        int sum = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            sum += card[i];
            max = Math.max(max, card[i]);
        }

        bw.write(String.valueOf(sum + ((N - 2) * max)));

        br.close();
        bw.close();
    }
}