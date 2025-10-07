package baekjoon.bronze.Num31009;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] costs = new int[N];
        int jinju = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String d = st.nextToken();
            costs[i] = Integer.parseInt(st.nextToken());

            if (d.equals("jinju")) {
                jinju = costs[i];
            }
        }

        int count = 0;
        for (int c : costs) {
            if (c > jinju) {
                count++;
            }
        }

        sb.append(jinju).append("\n").append(count);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}