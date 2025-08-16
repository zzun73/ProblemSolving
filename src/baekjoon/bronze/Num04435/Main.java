package baekjoon.bronze.Num04435;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] gandalf = new int[]{1, 2, 3, 3, 4, 10};
        int[] sauron = new int[]{1, 2, 2, 2, 3, 5, 10};
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int gSum = 0, sSum = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for (int g : gandalf) {
                int X = Integer.parseInt(st.nextToken());
                gSum += g * X;
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int s : sauron) {
                int X = Integer.parseInt(st.nextToken());
                sSum += s * X;
            }

            sb.append("Battle ").append(t).append(": ");
            if (gSum > sSum) {
                sb.append("Good triumphs over Evil");
            } else if (gSum < sSum) {
                sb.append("Evil eradicates all trace of Good");
            } else {
                sb.append("No victor on this battle field");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}