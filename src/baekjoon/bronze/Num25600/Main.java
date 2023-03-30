package baekjoon.bronze.Num25600;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int val = d + g;

            int sum = a * (d + g);
            if (a == val) {
                sum += a * (d + g);
            }
            answer = Math.max(sum, answer);
        }
        bw.write(answer + " ");

        br.close();
        bw.flush();
        bw.close();
    }
}
