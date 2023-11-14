package baekjoon.silver.Num01138;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < N; j++) {
                if (count == 0) {
                    if (arr[j] == 0) {
                        arr[j] = i + 1;
                        break;
                    }
                } else if (arr[j] == 0) {
                    count--;
                }
            }
        }

        for (int val : arr) {
            sb.append(val).append(" ");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}