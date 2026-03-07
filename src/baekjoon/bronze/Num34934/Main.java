package baekjoon.bronze.Num34934;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int max = 0;
        String answer = "";

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            int year = Integer.parseInt(st.nextToken());

            if (year > max) {
                max = year;
                answer = str;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}