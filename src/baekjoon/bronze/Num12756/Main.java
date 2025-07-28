package baekjoon.bronze.Num12756;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int aa = Integer.parseInt(st.nextToken());
        int al = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int ba = Integer.parseInt(st.nextToken());
        int bl = Integer.parseInt(st.nextToken());

        while (true) {
            al -= ba;
            bl -= aa;

            if (al <= 0 && bl <= 0) {
                sb.append("DRAW");
                break;
            } else if (al > 0 && bl <= 0) {
                sb.append("PLAYER A");
                break;
            } else if (al <= 0) {
                sb.append("PLAYER B");
                break;
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}