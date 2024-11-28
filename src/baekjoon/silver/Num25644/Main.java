package baekjoon.silver.Num25644;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        int answer = 0;
        int min = Integer.MAX_VALUE;
        while (N-- > 0) {
            int cur = Integer.parseInt(st.nextToken());
            answer = Math.max(answer, cur - min);
            min = Math.min(min, cur);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}