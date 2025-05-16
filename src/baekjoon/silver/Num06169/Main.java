package baekjoon.silver.Num06169;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        char[] mode = new char[T];
        for (int i = 0; i < T; i++) {
            mode[i] = br.readLine().charAt(0);
        }

        int sum = 0, idx = 0;
        while (sum <= M && idx < T) {
            if (mode[idx] == 'f') {
                sum += F * 2;
            } else if (mode[idx] == 'u' || mode[idx] == 'd') {
                sum += U + D;
            }
            if (sum > M) {
                break;
            }
            idx++;
        }

        bw.write(String.valueOf(idx));

        br.close();
        bw.close();
    }
}