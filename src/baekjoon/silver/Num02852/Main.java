package baekjoon.silver.Num02852;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int diff = 0, teamA = 0, teamB = 0, prevTime = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            String time = st.nextToken();
            st = new StringTokenizer(time, ":");
            int curTime = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

            if (diff > 0) {
                teamA += curTime - prevTime;
            }
            if (diff < 0) {
                teamB += curTime - prevTime;
            }
            diff += num == 1 ? 1 : -1;
            prevTime = curTime;
        }
        if (diff > 0) {
            teamA += 2880 - prevTime;
        }
        if (diff < 0) {
            teamB += 2880 - prevTime;
        }
        bw.write(String.format("%02d:%02d\n%02d:%02d", teamA / 60, teamA % 60, teamB / 60, teamB % 60));

        br.close();
        bw.flush();
        bw.close();
    }
}