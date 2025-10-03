package baekjoon.silver.Num01105;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        char[] L = st.nextToken().toCharArray();
        char[] R = st.nextToken().toCharArray();

        int answer = 0;
        if (L.length == R.length) {
            for (int i = 0; i < L.length; i++) {
                if (L[i] != R[i]) {
                    break;
                }

                answer += L[i] == '8' ? 1 : 0;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}