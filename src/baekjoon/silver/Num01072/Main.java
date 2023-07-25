package baekjoon.silver.Num01072;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        int Z = (int) (Y * 100 / X);

        long start = 0;
        long end = X;
        long answer = X;
        boolean flag = false;

        while (start <= end) {
            long mid = (start + end) / 2;
            long calcZ = (Y + mid) * 100 / (X + mid);
            if (calcZ <= Z) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = Math.min(answer, mid);
                flag = true;
            }
        }
        bw.write(flag ? String.valueOf(answer) : "-1");

        br.close();
        bw.flush();
        bw.close();

    }
}
