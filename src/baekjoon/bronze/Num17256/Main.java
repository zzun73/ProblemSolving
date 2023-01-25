package baekjoon.bronze.Num17256;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int aX = Integer.parseInt(st.nextToken());
        int aY = Integer.parseInt(st.nextToken());
        int aZ = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int cX = Integer.parseInt(st.nextToken());
        int cY = Integer.parseInt(st.nextToken());
        int cZ = Integer.parseInt(st.nextToken());

        bw.write((cX - aZ) + " " + (cY / aY) + " " + (cZ - aX) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
