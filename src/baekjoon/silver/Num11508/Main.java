package baekjoon.silver.Num11508;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, (n1, n2) -> n2 - n1);
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (i % 3 == 2) {
                continue;
            }
            answer += arr[i];
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
