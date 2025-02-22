package baekjoon.bronze.Num04299;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine()," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if((A + B) % 2 != 0 || A < B) {
            sb.append(-1);
        }else {
            sb.append(((A + B) / 2)).append(" ").append(((A + B) / 2) - B);
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}