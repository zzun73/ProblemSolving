package baekjoon.silver.Num21177;

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

        int answer = 0;
        for (int i = 0; i < N; ) {
            int current = arr[i];
            answer += current;
            i++;
            while (i < N && arr[i] == current + 1) {
                current = arr[i];
                i++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}