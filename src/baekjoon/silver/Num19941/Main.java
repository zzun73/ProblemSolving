package baekjoon.silver.Num19941;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] ch = br.readLine().toCharArray();

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (ch[i] == 'P') {
                int start = Math.max(i - K, 0);
                int end = Math.min(i + K, N - 1);
                while (start <= end) {
                    if (ch[start] == 'H') {
                        answer++;
                        ch[start] = 'X';
                        break;
                    }
                    start++;
                }
            }
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
