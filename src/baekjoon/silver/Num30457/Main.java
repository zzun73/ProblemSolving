package baekjoon.silver.Num30457;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[val]++;
        }

        int answer = 0;
        for (int i = 1; i < arr.length; i++) {
            answer += Math.min(arr[i], 2);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}