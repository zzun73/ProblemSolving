package baekjoon.bronze.Num30017;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        if (A > B) {
            A = B + 1;
        } else {
            B = A - 1;
        }
        bw.write(String.valueOf(A + B));

        br.close();
        bw.flush();
        bw.close();
    }
}