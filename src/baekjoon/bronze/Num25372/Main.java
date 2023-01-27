package baekjoon.bronze.Num25372;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();

            if (str.length() >= 6 && str.length() <= 9) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
