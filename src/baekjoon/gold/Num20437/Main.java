package baekjoon.gold.Num20437;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine().trim());

            List<Integer>[] pos = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                pos[i] = new ArrayList<>();
            }

            for (int i = 0; i < str.length(); i++) {
                pos[str.charAt(i) - 'a'].add(i);
            }

            int answerMin = Integer.MAX_VALUE, answerMax = Integer.MIN_VALUE;

            for (int ch = 0; ch < 26; ch++) {
                List<Integer> cur = pos[ch];
                if (cur.size() < K) {
                    continue;
                }

                for (int i = 0; i + K - 1 < cur.size(); i++) {
                    int len = cur.get(i + K - 1) - cur.get(i) + 1;
                    answerMin = Math.min(len, answerMin);
                    answerMax = Math.max(len, answerMax);
                }
            }

            if (answerMin == Integer.MAX_VALUE || answerMax == Integer.MIN_VALUE) {
                sb.append("-1").append("\n");
            } else {
                sb.append(answerMin).append(" ").append(answerMax).append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}