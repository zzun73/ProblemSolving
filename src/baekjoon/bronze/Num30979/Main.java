package baekjoon.bronze.Num30979;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        st = new StringTokenizer(br.readLine(), " ");
        while (N-- > 0) {
            sum += Integer.parseInt(st.nextToken());
        }

        bw.write(T <= sum ? "Padaeng_i Happy" : "Padaeng_i Cry");
        br.close();
        bw.close();
    }
}