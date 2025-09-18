package baekjoon.bronze.Num06889;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String[] adjectives = new String[n];
        for (int i = 0; i < n; i++) {
            adjectives[i] = br.readLine();
        }
        String[] nouns = new String[m];
        for (int i = 0; i < m; i++) {
            nouns[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(adjectives[i]).append(" as ").append(nouns[j]).append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}