package baekjoon.bronze.Num10797;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int day = Integer.parseInt(br.readLine());
        int answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 5; i++) {
            if (Integer.parseInt(st.nextToken()) == day) {
                answer++;
            }
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
