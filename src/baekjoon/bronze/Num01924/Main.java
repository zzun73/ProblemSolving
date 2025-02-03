package baekjoon.bronze.Num01924;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] month = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = new String[]{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        int cur = -1;

        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken());

        for (int i = 0; i < x; i++) {
            cur += month[i];
        }

        bw.write((day[(cur + y) % 7]));

        br.close();
        bw.close();
    }
}