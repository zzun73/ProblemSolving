package baekjoon.bronze.Num30032;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static char v(char c) {
        return "dbqp".charAt("qpdb".indexOf(c));
    }

    static char h(char c) {
        return "dbqp".charAt("bdpq".indexOf(c));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            for (char c : br.readLine().toCharArray()) {
                sb.append(D == 1 ? v(c) : h(c));
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}