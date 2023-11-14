package swea.d3.Num13038;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] weeks = new int[7];
            List<Integer> startDays = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < weeks.length; i++) {
                weeks[i] = Integer.parseInt(st.nextToken());
                if (weeks[i] == 1) {
                    startDays.add(i);
                }
            }

            int answer = Integer.MAX_VALUE;
            for (int startDay : startDays) {
                int day = 0;
                int count = 0;
                int idx = startDay;
                while (count < N) {
                    if (weeks[idx] == 1) {
                        count++;
                    }
                    idx = (idx + 1) % 7;
                    day++;
                }
                answer = Math.min(day, answer);
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}