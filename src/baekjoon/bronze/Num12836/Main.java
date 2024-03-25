package baekjoon.bronze.Num12836;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        long[] arr = new long[N + 1];

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    arr[a] += b;
                    break;
                case 2:
                    long sum = 0;
                    for (int i = a; i <= b; i++) {
                        sum += arr[i];
                    }
                    sb.append(sum).append("\n");
                    break;
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}