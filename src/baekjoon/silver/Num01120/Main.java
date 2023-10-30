package baekjoon.silver.Num01120;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        char[] A = st.nextToken().toCharArray();
        char[] B = st.nextToken().toCharArray();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= B.length - A.length; i++) {
            int cur = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] != B[i + j]) {
                    cur++;
                }
            }
            answer = Math.min(cur, answer);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}