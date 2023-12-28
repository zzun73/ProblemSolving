package baekjoon.bronze.Num02745;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        char[] N = st.nextToken().toCharArray();
        int B = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = 0; i < N.length; i++) {
            int cur = N[i];
            if (cur >= 'A') {
                cur = cur - 'A' + 10;
            } else {
                cur -= '0';
            }
            answer += (cur * Math.pow(B, N.length - i - 1));
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}