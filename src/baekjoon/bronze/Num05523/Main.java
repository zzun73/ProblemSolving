package baekjoon.bronze.Num05523;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int A = 0;
        int B = 0;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int val1 = Integer.parseInt(st.nextToken());
            int val2 = Integer.parseInt(st.nextToken());
            int garbage = val1 > val2 ? A++ : val1 < val2 ? B++ : 1;
        }
        bw.write(A + " " + B);

        br.close();
        bw.flush();
        bw.close();
    }
}
