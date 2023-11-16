package swea.d3.Num06485;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] busStops = new int[5001];

            for (int i = 1; i < N + 1; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                while (A <= B) {
                    busStops[A++]++;
                }
            }

            sb.append("#").append(t).append(" ");
            int P = Integer.parseInt(br.readLine());
            for (int i = 0; i < P; i++) {
                int pos = Integer.parseInt(br.readLine());
                sb.append(busStops[pos]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}