package baekjoon.silver.Num02108;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[8001];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int median = 10000;
        int mode = 10000;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            arr[value + 4000]++;
            if (max < value) {
                max = value;
            }
            if (min > value) {
                min = value;
            }
        }

        int count = 0;
        int modeMax = 0;
        boolean flag = false;

        for (int i = min + 4000; i <= max + 4000; i++) {
            if (arr[i] > 0) {

                if (count < (N + 1) / 2) {
                    count += arr[i];
                    median = i - 4000;
                }

                if (modeMax < arr[i]) {
                    modeMax = arr[i];
                    mode = i - 4000;
                    flag = true;
                } else if (modeMax == arr[i] && flag) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }

        bw.write((int) Math.round((double) sum / N) + "\n");
        bw.write(median + "\n");
        bw.write(mode + "\n");
        bw.write(max - min + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
