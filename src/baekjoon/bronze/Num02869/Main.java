package baekjoon.bronze.Num02869;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int answer;
        if ((V - B) % (A - B) == 0) {
            answer = (V - B) / (A - B);
        } else {
            answer = (V - B) / (A - B) + 1;
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
