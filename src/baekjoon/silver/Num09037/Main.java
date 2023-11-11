package baekjoon.silver.Num09037;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static boolean isSame() {
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void checkOdd() {
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 1) {
                arr[i] += 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            int[] basket = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            checkOdd();
            int answer = 0;
            while (!isSame()) {
                basket[0] = arr[N - 1] / 2;
                for (int i = 1; i < N; i++) {
                    basket[i] = arr[i - 1] / 2;
                }
                for (int i = 0; i < N; i++) {
                    arr[i] = arr[i] / 2 + basket[i];
                }

                checkOdd();
                answer++;
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}