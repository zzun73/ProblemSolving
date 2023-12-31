package baekjoon.bronze.Num11586;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
        int K = Integer.parseInt(br.readLine());
        switch (K) {
            case 1:
                for (String s : str) {
                    sb.append(s).append("\n");
                }
                break;
            case 2:
                for (String s : str) {
                    temp.append(s).reverse();
                    sb.append(temp).append("\n");
                    temp.setLength(0);
                }
                break;
            case 3:
                for (int i = N - 1; i >= 0; i--) {
                    sb.append(str[i]).append("\n");
                }
                break;
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}