package baekjoon.silver.Num01813;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] count = new int[51];

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(st.nextToken());
            count[X]++;
        }

        int answer = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == i) {
                answer = i;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}