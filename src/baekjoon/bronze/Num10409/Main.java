package baekjoon.bronze.Num10409;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int answer;

        st = new StringTokenizer(br.readLine(), " ");
        for (answer = 0; answer < n; answer++) {
            T -= Integer.parseInt(st.nextToken());
            if (T < 0) {
                break;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}