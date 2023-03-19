package baekjoon.bronze.Num21665;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        br.readLine();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == line[j]) {
                    answer++;
                }
            }
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
