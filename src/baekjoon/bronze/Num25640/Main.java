package baekjoon.bronze.Num25640;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (str.equals(br.readLine())) {
                answer++;
            }
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
