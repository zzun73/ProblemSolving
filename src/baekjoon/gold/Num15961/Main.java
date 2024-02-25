package baekjoon.gold.Num15961;

import java.io.*;
import java.util.*;

public class Main {
    static int N, d, k, c, answer, count;
    static int[] table, selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        table = new int[N];
        selected = new int[d + 1];
        for (int i = 0; i < N; i++) {
            table[i] = Integer.parseInt(br.readLine());
        }

        answer = 1;
        selected[c]++;
        for (int i = 0; i < k; i++) {
            if (selected[table[i]] == 0) {
                answer++;
            }
            selected[table[i]]++;
        }

        count = answer;
        for (int i = 0; i < N - 1; i++) {
            selected[table[i]]--;
            if (selected[table[i]] == 0) {
                count--;
            }

            selected[table[(i + k) % N]]++;
            if (selected[table[(i + k) % N]] == 1) {
                count++;
            }

            answer = Math.max(count, answer);
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
