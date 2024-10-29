package baekjoon.silver.Num25193;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (char ch : br.readLine().toCharArray()) {
            if (ch == 'C') {
                count++;
            }
        }

        bw.write(String.valueOf(count / (N - count + 1) + (count % (N - count + 1) != 0 ? 1 : 0)));

        br.close();
        bw.close();
    }
}