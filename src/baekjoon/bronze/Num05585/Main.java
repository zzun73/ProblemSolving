package baekjoon.bronze.Num05585;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] change = new int[]{500, 100, 50, 10, 5, 1};
        int money = 1000 - N, answer = 0, count;

        for (int coin : change) {
            count = money / coin;
            if (count > 0) {
                answer += count;
                money %= coin;
            }
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
