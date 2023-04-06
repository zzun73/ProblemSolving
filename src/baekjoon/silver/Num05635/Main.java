package baekjoon.silver.Num05635;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String[][] str = new String[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            str[i][0] = st.nextToken();
            String d = String.format("%02d", Integer.parseInt(st.nextToken()));
            String m = String.format("%02d", Integer.parseInt(st.nextToken()));
            String y = st.nextToken();
            str[i][1] = y + m + d;
        }
        Arrays.sort(str, Comparator.comparingInt(o -> Integer.parseInt(o[1])));
        bw.write(str[N - 1][0] + "\n" + str[0][0]);

        br.close();
        bw.flush();
        bw.close();
    }
}
