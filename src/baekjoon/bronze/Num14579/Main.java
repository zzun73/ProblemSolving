package baekjoon.bronze.Num14579;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int MOD = 14579;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int temp = (a + 1) * a / 2;
        temp %= MOD;
        int answer = temp;
        for (int i = a + 1; i <= b; i++) {
            answer *= (temp += i);
            answer %= MOD;
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}