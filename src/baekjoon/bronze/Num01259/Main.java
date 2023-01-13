package baekjoon.bronze.Num01259;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String Y = "yes\n";
        String N = "no\n";
        boolean check;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            check = true;
            if (str.charAt(0) == '0') {
                break;
            }

            for (int i = 0; i < str.length() / 2; i++) {
                char ch1 = str.charAt(i);
                char ch2 = str.charAt(str.length() - i - 1);
                if (ch1 != ch2) {
                    check = false;
                    break;
                }
            }

            if (check) {
                bw.write(Y);
            } else {
                bw.write(N);
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
