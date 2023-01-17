package baekjoon.bronze.Num04101;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int A, B;
        String yes = "Yes\n";
        String no = "No\n";

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            if (A + B == 0) {
                break;
            }
            if (A > B) {
                bw.write(yes);
            } else {
                bw.write(no);
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
