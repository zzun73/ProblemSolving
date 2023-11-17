package swea.d2.Num01945;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] values = new int[]{2, 3, 5, 7, 11};
        int[] answer = new int[5];
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < values.length; i++) {
               while (N % values[i] == 0) {
                    N /= values[i];
                    answer[i]++;
                }
            }

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < answer.length; i++) {
                sb.append(answer[i]).append(" ");
                answer[i] = 0;
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}