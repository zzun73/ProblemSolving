package baekjoon.bronze.Num11557;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] S = new String[N];
            int[] L = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                S[i] = st.nextToken();
                L[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            int index = 0;
            for (int i = 0; i < N; i++) {
                if (max < L[i]) {
                    max = L[i];
                    index = i;
                }
            }
            bw.write(S[index] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
