package baekjoon.silver.Num18787;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String A = br.readLine();
        String B = br.readLine();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) != B.charAt(i)) {
                answer++;
                while (i < n && A.charAt(i) != B.charAt(i)) {
                    i++;
                }
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}