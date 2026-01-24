package baekjoon.bronze.Num21866;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int[] maxScore = new int[]{100, 100, 200, 200, 300, 300, 400, 400, 500};
        int sum = 0;
        boolean isHacker = false;
        for (int i = 0; i < 9; i++) {
            int X = Integer.parseInt(st.nextToken());
            if (X > maxScore[i]) {
                isHacker = true;
                break;
            }
            sum += X;
        }

        if (isHacker) {
            bw.write("hacker");
        } else {
            bw.write(sum >= 100 ? "draw" : "none");
        }

        br.close();
        bw.close();
    }
}