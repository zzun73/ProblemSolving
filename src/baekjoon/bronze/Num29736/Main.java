package baekjoon.bronze.Num29736;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int A, B, K, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = K - X; i <= K + X; i++) {
            if (i >= A && i <= B) {
                answer++;
            }
        }
        bw.write(answer == 0 ? "IMPOSSIBLE" : String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
