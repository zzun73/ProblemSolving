package swea.d3.Num01217;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static int helper(int sum, int N, int M) {
        if (M == 0) {
            return sum;
        }
        return helper(sum * N, N, M - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            br.readLine();
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append("#").append(t).append(" ").append(helper(1, N, M)).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}