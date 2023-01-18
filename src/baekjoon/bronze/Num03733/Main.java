package baekjoon.bronze.Num03733;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            String str = br.readLine();
            if (str == null) {
                break;
            }
            st = new StringTokenizer(str, " ");
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            bw.write(S / (N + 1) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
