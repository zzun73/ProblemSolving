package baekjoon.silver.Num17087;

import java.io.*;
import java.util.*;

public class Main {

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int answer = Math.abs(S - Integer.parseInt(st.nextToken()));
        for (int i = 1; i < N; i++) {
            int pos = Integer.parseInt(st.nextToken());
            answer = gcd(answer, Math.abs(S - pos));
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}