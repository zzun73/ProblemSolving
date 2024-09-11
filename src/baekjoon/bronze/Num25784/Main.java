package baekjoon.bronze.Num25784;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a + b == c || a + c == b || b + c == a) {
            bw.write(String.valueOf(1));
        } else if (a * b == c || a * c == b || b * c == a) {
            bw.write(String.valueOf(2));
        } else {
            bw.write(String.valueOf(3));
        }

        br.close();
        bw.close();
    }
}