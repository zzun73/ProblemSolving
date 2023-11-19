package swea.d3.Num13229;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] days = new String[]{"", "SAT", "FRI", "THU", "WED", "TUE", "MON", "SUN"};
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int answer = 7;
            String day = br.readLine();
            for (int i = 1; i < days.length; i++) {
                if (day.equals(days[i])) {
                    answer = i;
                    break;
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