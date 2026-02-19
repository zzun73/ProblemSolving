package baekjoon.bronze.Num09610;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] area = new int[5];

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == 0 || y == 0) {
                area[4]++;
            } else if (x > 0 && y > 0) {
                area[0]++;
            } else if (x < 0 && y > 0) {
                area[1]++;
            } else if (x < 0 && y < 0) {
                area[2]++;
            } else if (x > 0 && y < 0) {
                area[3]++;
            }
        }

        String[] outputPrefix = new String[]{"Q1: ", "Q2: ", "Q3: ", "Q4: ", "AXIS: "};
        for (int i = 0; i < area.length; i++) {
            sb.append(outputPrefix[i]).append(area[i]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}