package baekjoon.bronze.Num26004;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = Integer.MAX_VALUE;
        int[] visited = new int['Z' + 1];
        for (char ch : br.readLine().toCharArray()) {
            if (ch == 'H' || ch == 'I' || ch == 'A' || ch == 'R' || ch == 'C') {
                visited[ch]++;
            }
        }

        for (char ch : "HIARC".toCharArray()) {
            answer = Math.min(answer, visited[ch]);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}