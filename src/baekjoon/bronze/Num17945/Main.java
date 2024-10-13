package baekjoon.bronze.Num17945;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int root = (int) Math.sqrt(A * A - B);
        int res1 = (-1 * A) - root;
        int res2 = (-1 * A) + root;

        bw.write(String.valueOf(res1 == res2 ? res1 : res1 + " " + res2));

        br.close();
        bw.close();
    }
}