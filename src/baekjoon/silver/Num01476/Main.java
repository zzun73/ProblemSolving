package baekjoon.silver.Num01476;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 1;
        while (true) {
            if ((answer - E) % 15 == 0 && (answer - S) % 28 == 0 && (answer - M) % 19 == 0) {
                break;
            }
            answer++;
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
