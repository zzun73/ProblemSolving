package baekjoon.bronze.Num15781;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] answer = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};

        st = new StringTokenizer(br.readLine(), " ");
        while (N-- > 0) {
            answer[0] = Math.max(answer[0], Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");
        while (M-- > 0) {
            answer[1] = Math.max(answer[1], Integer.parseInt(st.nextToken()));
        }

        bw.write(answer[0] + answer[1] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
