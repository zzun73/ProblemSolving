package baekjoon.bronze.Num17094;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        String s = br.readLine();

        int cnt2 = 0, cnte = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '2') {
                cnt2++;
            } else {
                cnte++;
            }
        }

        if (cnt2 > cnte) {
            bw.write("2");
        } else if (cnt2 < cnte) {
            bw.write("e");
        } else {
            bw.write("yee");
        }

        br.close();
        bw.close();
    }
}