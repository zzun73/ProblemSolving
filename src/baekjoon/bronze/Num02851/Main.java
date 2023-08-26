package baekjoon.bronze.Num02851;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = 10;
        int diff = 100;
        int answer = 0;
        int sum = 0;
        while (size-- > 0) {
            sum += Integer.parseInt(br.readLine());
            if (Math.abs(100 - sum) <= diff) {
                diff = Math.abs(100 - sum);
                answer = sum;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
