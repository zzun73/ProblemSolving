package baekjoon.bronze.Num28289;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());
        int[] arr = new int[4];
        while (P-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int G = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            if (G < 2) {
                arr[3]++;
            } else {
                if (C <= 2) {
                    arr[0]++;
                } else if (C == 3) {
                    arr[1]++;
                } else if (C == 4) {
                    arr[2]++;
                }
            }
        }

        for (int val : arr) {
            sb.append(val).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}