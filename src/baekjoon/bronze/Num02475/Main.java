package baekjoon.bronze.Num02475;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 5; i++) {
            int value = Integer.parseInt(st.nextToken());
            answer += value * value;
        }
        System.out.println(answer % 10);

        br.close();
    }
}
