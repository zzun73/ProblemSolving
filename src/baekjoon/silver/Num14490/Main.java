package baekjoon.silver.Num14490;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), ":");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int a = n, b = m;
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        bw.write(n / a + ":" + m / a);

        br.close();
        bw.flush();
        bw.close();
    }
}
