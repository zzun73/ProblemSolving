package baekjoon.silver.Num30088;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int number = Integer.parseInt(st.nextToken());
            while (number-- > 0) {
                arr[i] += Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr);

        long answer = 0;
        long sum = 0;
        for (int val : arr) {
            sum += val;
            answer += sum;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}