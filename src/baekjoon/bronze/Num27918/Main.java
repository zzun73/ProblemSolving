package baekjoon.bronze.Num27918;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int pointD, pointP;
        pointD = pointP = 0;
        while (N-- > 0 && Math.abs(pointD - pointP) < 2) {
            String s = br.readLine();
            if (s.equals("D")) {
                pointD++;
            } else {
                pointP++;
            }
        }
        sb.append(pointD).append(":").append(pointP);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
