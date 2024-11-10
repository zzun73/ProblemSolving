package baekjoon.bronze.Num14215;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int answer;

        int[] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        if (arr[0] >= arr[1] + arr[2]) {
            arr[0] = arr[1] + arr[2] - 1;
        }
        if (arr[1] >= arr[0] + arr[2]) {
            arr[1] = arr[0] + arr[2] - 1;
        }
        if (arr[2] >= arr[0] + arr[1]) {
            arr[2] = arr[0] + arr[1] - 1;
        }
        answer = arr[0] + arr[1] + arr[2];

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}