package baekjoon.silver.Num29615;

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

        int count = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int val = Integer.parseInt(st.nextToken());
            boolean flag = true;
            for (int j = 0; j < M; j++) {
                if (val == arr[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}