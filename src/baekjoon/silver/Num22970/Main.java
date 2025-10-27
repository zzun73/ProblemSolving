package baekjoon.silver.Num22970;

import java.io.*;
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

        int answer = 0;
        for (int i = 0; i < N; i++) {

            int j = i;
            while (j+1 < N && arr[j] < arr[j + 1]) {
                j++;
            }

            int k = j;
            while (k+1 < N && arr[k] > arr[k + 1]) {
                k++;
            }

            answer = Math.max(answer, k - i + 1);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}