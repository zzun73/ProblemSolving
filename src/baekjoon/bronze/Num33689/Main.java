package baekjoon.bronze.Num33689;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        while (N-- > 0) {
            if (br.readLine().charAt(0) == 'C') {
                answer++;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}