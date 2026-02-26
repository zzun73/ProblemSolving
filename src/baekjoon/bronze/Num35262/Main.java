package baekjoon.bronze.Num35262;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;
        boolean flag = true;
        for (char ch : br.readLine().toCharArray()) {
            if (ch == '0') {
                count++;
                if (count == K) {
                    flag = false;
                    break;
                }
            } else {
                count = 0;
            }
        }
        bw.write(String.valueOf(flag ? 1 : 0));

        br.close();
        bw.close();
    }
}