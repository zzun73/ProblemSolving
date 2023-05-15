package baekjoon.silver.Num14912;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] arr = new int[10];
        for (int i = 1; i <= n; i++) {
            int val = i;
            while (val != 0) {
                arr[val % 10]++;
                val /= 10;
            }
        }
        bw.write(arr[d] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
