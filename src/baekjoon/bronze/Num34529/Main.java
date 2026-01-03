package baekjoon.bronze.Num34529;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int U = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int x = U / 100 + (U % 100 > 0 ? 1 : 0);
        int y = V / 50 + (V % 50 > 0 ? 1 : 0);
        int z = W / 20 + (W % 20 > 0 ? 1 : 0);

        int answer = (x * X) + (y * Y) + (z * Z);
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}