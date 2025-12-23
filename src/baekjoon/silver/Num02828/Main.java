package baekjoon.silver.Num02828;

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

        int J = Integer.parseInt(br.readLine());
        int L = 1;
        int R = M;

        int count = 0;
        for (int i = 0; i < J; i++) {
            int cur = Integer.parseInt(br.readLine());

            if (cur < L) {
                int diff = L - cur;
                L -= diff;
                R -= diff;
                count += diff;
            } else if (R < cur) {
                int diff = cur - R;
                L += diff;
                R += diff;
                count += diff;
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}