package swea.d3.Num02805;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 0, start = N / 2, end = N / 2, mid = N / 2;
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = ch[j] - '0';
                }

                for (int j = start; j <= end; j++) {
                    answer += arr[i][j];
                }
                if (i + 1 <= mid) {
                    start -= 1;
                    end += 1;
                } else {
                    start += 1;
                    end -= 1;
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
