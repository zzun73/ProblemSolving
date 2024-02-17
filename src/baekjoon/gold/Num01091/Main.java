package baekjoon.gold.Num01091;

import java.io.*;
import java.util.*;

public class Main {
    static int N, answer;
    static int[] P, S, temp, init;

    static boolean isEnd() {
        for (int i = 0; i < N; i++) {
            int idx = i % 3;
            if (P[i] != idx) {
                return false;
            }
        }
        return true;
    }

    static void shuffle() {
        for (int i = 0; i < N; i++) {
            temp[S[i]] = P[i];
        }

        P = temp.clone();
    }

    static boolean isCycle() {
        for (int i = 0; i < N; i++) {
            if (init[i] != P[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        P = new int[N];
        S = new int[N];
        temp = new int[N];
        answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        init = P.clone(); // 초기 상태 검증

        while (true) {
            if (isEnd()) {
                break;
            }

            shuffle();

            if (isCycle()) {
                answer = -1;
                break;
            }

            answer++;
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}