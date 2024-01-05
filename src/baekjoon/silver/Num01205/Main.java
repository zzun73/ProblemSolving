package baekjoon.silver.Num01205;

import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int N, score, P, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        score = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        if (N != 0) {
            arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        if (N == P && arr[N - 1] >= score) {
            answer = -1;
        } else {
            answer = 1;
            for (int i = 0; i < N; i++) {
                if (arr[i] > score) {
                    answer++;
                } else {
                    break;
                }
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}