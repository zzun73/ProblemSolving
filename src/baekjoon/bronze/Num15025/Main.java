package baekjoon.bronze.Num15025;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        if (l == 0 && r == 0) {
            sb.append("Not a moose");
        } else {
            sb.append((l == r) ? "Even" : "Odd").append(" ").append(Math.max(l, r) * 2);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}