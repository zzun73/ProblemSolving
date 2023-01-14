package baekjoon.bronze.Num10103;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int h1 = 100, h2 = 100;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            if (X > Y) {
                h2 -= X;
            } else if (X < Y) {
                h1 -= Y;
            }
        }
        bw.write(h1 + "\n" + h2);

        br.close();
        bw.flush();
        bw.close();
    }
}
