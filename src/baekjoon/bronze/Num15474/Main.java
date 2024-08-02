package baekjoon.bronze.Num15474;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int t1 = n / a + (n % a != 0 ? 1 : 0);
        int t2 = n / c + (n % c != 0 ? 1 : 0);
        bw.write(String.valueOf(Math.min(t1 * b, t2 * d)));

        br.close();
        bw.close();
   }
}