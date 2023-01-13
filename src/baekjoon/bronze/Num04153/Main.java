package baekjoon.bronze.Num04153;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String Y = "right\n";
        String N = "wrong\n";
        int a, b, c, A, B, C;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if ((a + b + c) == 0) {
                break;
            }
            A = a * a;
            B = b * b;
            C = c * c;
            if (A + B == C || A + C == B || B + C == A) {
                bw.write(Y);
            } else {
                bw.write(N);
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
