package baekjoon.silver.Num14582;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] arr = new int[9];
        int sumA = 0, sumB = 0;
        boolean flag = false;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 9; i++) {
            sumA += arr[i];
            if (sumA > sumB) {
                flag = true;
                break;
            }

            int curB = Integer.parseInt(st.nextToken());
            sumB += curB;
        }
        bw.write(flag ? "Yes" : "No");

        br.close();
        bw.flush();
        bw.close();
    }
}