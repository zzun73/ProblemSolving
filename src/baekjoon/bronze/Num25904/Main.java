package baekjoon.bronze.Num25904;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int answer, idx = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            if (arr[idx] < X) {
                answer = idx % N + 1;
                break;
            }
            idx = (idx + 1) % N;
            X++;
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
