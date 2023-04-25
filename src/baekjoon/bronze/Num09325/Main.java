package baekjoon.bronze.Num09325;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int s = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                s += (p * q);
            }
            bw.write(s + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
