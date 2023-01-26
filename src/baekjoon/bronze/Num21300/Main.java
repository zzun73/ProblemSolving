package baekjoon.bronze.Num21300;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;
        for (int i = 0; i < 6; i++) {
            answer += Integer.parseInt(st.nextToken());
        }

        bw.write(5 * answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
