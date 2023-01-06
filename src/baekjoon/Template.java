package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Template {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(st.nextToken());
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
