package baekjoon.bronze.Num02566;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] arr = new int[10][10];
        int max = 0;
        int row = 0, col = 0;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        bw.write(max + "\n");
        bw.write((row + 1) + " " + (col + 1));

        br.close();
        bw.flush();
        bw.close();
    }
}
