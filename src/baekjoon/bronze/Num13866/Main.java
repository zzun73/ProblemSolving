package baekjoon.bronze.Num13866;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
        }
        Arrays.sort(arr);
        bw.write(Math.abs((arr[0] + arr[3]) - (arr[1] + arr[2])) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
