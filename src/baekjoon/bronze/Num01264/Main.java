package baekjoon.bronze.Num01264;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine().toLowerCase();
            if (line.equals("#")) {
                break;
            }

            int count = 0;
            for (char ch : line.toCharArray()) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++;
                }
            }
            bw.write(count + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
