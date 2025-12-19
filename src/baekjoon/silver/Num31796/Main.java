package baekjoon.silver.Num31796;

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

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int answer = 1;
        int i = 0;
        for (; i < N; i++) {
            int limit = arr[i] * 2;
            for (int j = i + 1; j < N; j++) {
                int cur = arr[j];
                if (cur >= limit) {
                    answer++;
                    i = j - 1;
                    break;
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}