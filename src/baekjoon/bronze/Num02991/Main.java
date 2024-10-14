package baekjoon.bronze.Num02991;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 3; i++) {
            int cur = Integer.parseInt(st.nextToken());
            int answer = 0;

            if ((cur % (A + B) > 0) && (cur % (A + B) <= A)) {
                answer++;
            }

            if ((cur % (C + D) > 0) && (cur % (C + D) <= C)) {
                answer++;
            }

            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}