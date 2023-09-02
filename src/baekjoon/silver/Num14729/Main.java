package baekjoon.silver.Num14729;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[100001];
        int count = 0;

        for (int i = 0; i < N; i++) {
            arr[(int) (Double.parseDouble(br.readLine()) * 1000)]++;
        }

        for (int i = 0; i < arr.length; i++) {
            while (arr[i]-- > 0 && count < 7) {
                sb.append(String.format("%.3f\n", i / 1000.0));
                count++;
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
