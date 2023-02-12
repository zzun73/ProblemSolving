package baekjoon.bronze.Num04796;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int cnt = 0;
        while (true) {
            cnt++;
            st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if (L + P + V == 0) {
                break;
            }
            int answer;
            answer = L * (V / P) + Math.min(L, V % P);

            bw.write("Case " + cnt + ": " + answer + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
