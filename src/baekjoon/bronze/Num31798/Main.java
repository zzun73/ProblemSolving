package baekjoon.bronze.Num31798;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = 0;
        if (a == 0) {
            answer = c * c - b;
        } else if (b == 0) {
            answer = c * c - a;
        } else if (c == 0) {
            answer = (int) Math.sqrt(a + b);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}