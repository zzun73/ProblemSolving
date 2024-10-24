package baekjoon.bronze.Num17496;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int day = 1;
        int answer = 0;
        while (true) {
            day += T;
            if (day > N) {
                break;
            }
            answer += C * P;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}