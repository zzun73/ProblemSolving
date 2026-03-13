package baekjoon.bronze.Num03449;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] input1 = br.readLine().toCharArray();
            char[] input2 = br.readLine().toCharArray();
            int answer = 0;

            for (int i = 0; i < input1.length; i++) {
                if (input1[i] != input2[i]) {
                    answer++;
                }
            }

            sb.append("Hamming distance is ").append(answer).append(".").append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}