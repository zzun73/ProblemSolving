package baekjoon.bronze.Num17356;

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

        double answer = 1 / (1 + Math.pow(10, (B - A) / 400.0));

        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }
}
