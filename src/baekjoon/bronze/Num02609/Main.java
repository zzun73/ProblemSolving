package baekjoon.bronze.Num02609;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int helper(int a, int b) {
        if (b == 0)
            return a;
        return helper(b, a % b);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int c = helper(a, b);

        bw.write(c + "\n");
        bw.write(a * b / c + "");

        br.close();
        bw.flush();
        bw.close();
    }
}