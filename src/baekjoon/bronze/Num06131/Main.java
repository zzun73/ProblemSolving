package baekjoon.bronze.Num06131;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 1; i <= 500; i++) {
            int cur = i * i + n;
            int sqrt = (int) Math.sqrt(cur);

            if (sqrt > 500) {
                break;
            }
            if (Math.pow(sqrt, 2) == cur) {
                answer++;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}