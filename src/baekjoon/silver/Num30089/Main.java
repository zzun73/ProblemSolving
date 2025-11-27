package baekjoon.silver.Num30089;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String str = br.readLine();
            int size = str.length();
            int idx = 0;

            for (int i = 0; i < size; i++) {
                boolean ok = true;
                int l = i;
                int r = size - 1;

                while (l < r) {
                    if (str.charAt(l++) != str.charAt(r--)) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    idx = i;
                    break;
                }
            }

            StringBuilder tail = new StringBuilder();
            tail.append(str, 0, idx).reverse();

            sb.append(str).append(tail).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}