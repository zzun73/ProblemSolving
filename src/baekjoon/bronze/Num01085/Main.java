package baekjoon.bronze.Num01085;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int xposMin = Math.min(w - x, x);
        int yposMin = Math.min(h - y, y);
        int answer = Math.min(xposMin, yposMin);

        System.out.println(answer);
        br.close();
        bw.flush();
        bw.close();
    }
}
