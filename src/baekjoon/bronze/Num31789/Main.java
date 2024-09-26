package baekjoon.bronze.Num31789;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        boolean flag = false;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int C = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            if (X >= C && P > S) {
                flag = true;
                break;
            }
        }
        bw.write(flag ? "YES" : "NO");

        br.close();
        bw.close();
    }
}