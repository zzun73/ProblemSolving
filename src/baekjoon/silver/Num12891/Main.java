package baekjoon.silver.Num12891;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int S, P, answer;
    static char[] dna;
    static int[] conditions; // A, C, G, T
    static int[] counts; // A, C, G, T

    // P 크기를 유지한 채로 탐색 진행
    static void helper() {
        init();

        for (int i = P; i < dna.length; i++) {
            counts[update(dna[i - P])]--; // 시작지점(이전 부분) 빼주기
            counts[update(dna[i])]++; // 도착지점(새로 추가된 부분) 더해주기

            if (checker()) {
                answer++;
            }

        }
    }

    // 문자에 해당하는 idx 탐색
    static int update(char ch) {
        int idx = -1;
        switch (ch) {
            case 'A':
                idx = 0;
                break;
            case 'C':
                idx = 1;
                break;
            case 'G':
                idx = 2;
                break;
            case 'T':
                idx = 3;
                break;
        }

        return idx;
    }

    // 비밀번호 최소 개수 확인
    static boolean checker() {
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] < conditions[i]) {
                return false;
            }
        }
        return true;
    }

    // 탐색할 범위인 P 크기만큼 초기값 설정
    static void init() {
        for (int i = 0; i < P; i++) {
            switch (dna[i]) {
                case 'A':
                    counts[0]++;
                    break;
                case 'C':
                    counts[1]++;
                    break;
                case 'G':
                    counts[2]++;
                    break;
                case 'T':
                    counts[3]++;
                    break;
            }
        }
        if (checker()) {
            answer++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        answer = 0;
        dna = br.readLine().toCharArray();

        counts = new int[4];
        conditions = new int[4];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < conditions.length; i++) {
            conditions[i] = Integer.parseInt(st.nextToken());
        }

        helper();

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}

