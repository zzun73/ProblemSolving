package baekjoon.bronze.Num28097;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int sum = 0;

        sum += (N - 1) * 8;
        while (N-- > 0) {
            sum += Integer.parseInt(st.nextToken());
        }
        sb.append(sum / 24).append(" ").append(sum % 24);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
