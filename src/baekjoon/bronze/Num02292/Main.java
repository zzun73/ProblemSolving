package baekjoon.bronze.Num02292;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 1;
        int range = 2;

        if (N == 1) {
            System.out.print(answer);
        } else {
            while (range <= N) {
                range = range + (6 * answer);
                answer++;
            }
            System.out.print(answer);
        }
    }
}
