package baekjoon.silver.Num10815;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);

        int key, index;
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while (M-- > 0) {
            key = Integer.parseInt(st.nextToken());
            index = Arrays.binarySearch(arrN, key);
            if (index < 0) {
                bw.write("0 ");
            } else {
                bw.write("1 ");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
