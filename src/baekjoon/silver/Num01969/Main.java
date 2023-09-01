package baekjoon.silver.Num01969;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dna = new int[4][M];
        StringBuilder sb = new StringBuilder();
        int hd = 0;

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                switch (input[j]) {
                    case 'A':
                        dna[0][j]++;
                        break;
                    case 'C':
                        dna[1][j]++;
                        break;
                    case 'G':
                        dna[2][j]++;
                        break;
                    case 'T':
                        dna[3][j]++;
                        break;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            int val = -1;
            int idx = -1;
            for (int j = 0; j < 4; j++) {
                if (val < dna[j][i]) {
                    val = dna[j][i];
                    idx = j;
                }
            }
            switch (idx) {
                case 0:
                    sb.append("A");
                    break;
                case 1:
                    sb.append("C");
                    break;
                case 2:
                    sb.append("G");
                    break;
                case 3:
                    sb.append("T");
                    break;
            }
            hd += N - val;
        }
        sb.append("\n").append(hd);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
