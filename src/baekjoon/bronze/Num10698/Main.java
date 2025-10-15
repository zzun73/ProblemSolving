package baekjoon.bronze.Num10698;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int Y = Integer.parseInt(st.nextToken());
            st.nextToken();
            int Z = Integer.parseInt(st.nextToken());

            boolean result = (op.charAt(0) == '+') ? (X + Y == Z) : (X - Y == Z);

            sb.append("Case ").append(t).append(": ").append(result ? "YES" : "NO").append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}