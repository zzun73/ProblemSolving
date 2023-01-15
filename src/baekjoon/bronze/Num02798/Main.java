package baekjoon.bronze.Num02798;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int helper(int[] arr, int N, int M) {
        int result = 0;

        for (int i = 0; i < N - 2; i++) {
            if (arr[i] > M) continue;

            for (int j = i + 1; j < N - 1; j++) {
                if (arr[i] + arr[j] > M) continue;

                for (int k = j + 1; k < N; k++) {
                    int temp = arr[i] + arr[j] + arr[k];
                    if (M == temp) {
                        return temp;
                    }
                    if (result < temp && temp < M) {
                        result = temp;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = helper(arr, N, M);
        System.out.println(answer);
    }
}