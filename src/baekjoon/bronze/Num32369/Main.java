package baekjoon.bronze.Num32369;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int praiseOnion = 1;
        int blameOnion = 1;

        while (N-- > 0) {
            praiseOnion += A;
            blameOnion += B;

            if (blameOnion > praiseOnion) {
                int temp = praiseOnion;
                praiseOnion = blameOnion;
                blameOnion = temp;
            }

            if (praiseOnion == blameOnion) {
                blameOnion--;
            }
        }

        sb.append(praiseOnion).append(" ").append(blameOnion);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}