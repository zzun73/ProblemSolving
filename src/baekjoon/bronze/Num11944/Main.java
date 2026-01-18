package baekjoon.bronze.Num11944;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        String N = st.nextToken();
        int M = Integer.parseInt(st.nextToken());

        int count = Integer.parseInt(N);

        for (int i = 0; i < count && sb.length() < M; i++) {
            if (sb.length() + N.length() > M) {
                sb.append(N, 0, M - sb.length());
                break;
            }
            sb.append(N);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}