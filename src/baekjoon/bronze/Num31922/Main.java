package baekjoon.bronze.Num31922;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int answer = Math.max(a + c, p);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}