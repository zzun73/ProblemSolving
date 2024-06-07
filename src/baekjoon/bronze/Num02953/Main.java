package baekjoon.bronze.Num02953;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int max = 0, n = 0, sum;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += Integer.parseInt(st.nextToken());
            }

            if (max < sum) {
                max = sum;
                n = i + 1;
            }
        }
        sb.append(n).append(" ").append(max);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}