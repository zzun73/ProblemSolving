package baekjoon.bronze.Num10250;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int Y, X;

            if (N % H == 0) {
                Y = H * 100;
                X = N / H;

            } else {
                Y = N % H * 100;
                X = N / H + 1;
            }
            bw.write(Y + X + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
