package baekjoon.bronze.Num28453;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(tk.nextToken());
            if (M < 250) {
                sb.append("4");
            } else if (M < 275) {
                sb.append("3");
            } else if (M < 300) {
                sb.append("2");
            } else {
                sb.append("1");
            }
            sb.append(" ");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}