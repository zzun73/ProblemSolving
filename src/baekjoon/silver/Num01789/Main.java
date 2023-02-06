package baekjoon.silver.Num01789;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long S = Long.parseLong(br.readLine());
        int i = 1, count = 0, answer;
        long sum = 0L;

        while (true) {
            sum += i++;
            count++;
            if (sum > S) {
                answer = count - 1;
                break;
            }
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
