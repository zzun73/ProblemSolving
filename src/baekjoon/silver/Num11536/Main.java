package baekjoon.silver.Num11536;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        str[0] = br.readLine();
        int count = 0;
        for (int i = 1; i < N; i++) {
            str[i] = br.readLine();
            if (str[i].compareTo(str[i - 1]) > 0) {
                count++;
            } else {
                count--;
            }
        }
        bw.write(count == N - 1 ? "INCREASING" : count == -(N - 1) ? "DECREASING" : "NEITHER");

        br.close();
        bw.flush();
        bw.close();
    }
}
