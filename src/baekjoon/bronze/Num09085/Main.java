package baekjoon.bronze.Num09085;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Integer.parseInt(st.nextToken());
            }
            bw.write(sum + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
