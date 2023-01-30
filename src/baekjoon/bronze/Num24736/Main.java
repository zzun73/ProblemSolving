package baekjoon.bronze.Num24736;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int answer;
        int[] point = new int[]{6, 3, 2, 1, 2};
        int T = 2;

        while (T-- > 0) {
            answer = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int input : point) {
                answer += input * Integer.parseInt(st.nextToken());
            }
            bw.write(answer + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
