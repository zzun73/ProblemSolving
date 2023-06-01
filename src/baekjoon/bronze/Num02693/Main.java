package baekjoon.bronze.Num02693;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            bw.write(arr[7] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
