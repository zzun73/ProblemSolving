package baekjoon.bronze.Num16727;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int p1 = Integer.parseInt(st.nextToken());
        int s1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int s2 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        if (p1 + p2 > s1 + s2) {
            bw.write("Persepolis");
        } else if (p1 + p2 < s1 + s2) {
            bw.write("Esteghlal");
        } else if (p1 + p2 == s1 + s2) {
            if (p2 > s1) {
                bw.write("Persepolis");
            } else if (p2 < s1) {
                bw.write("Esteghlal");
            } else {
                bw.write("Penalty");
            }
        }

        br.close();
        bw.close();
    }
}