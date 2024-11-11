package baekjoon.bronze.Num04892;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = 1;
        while (true) {
            int cur = Integer.parseInt(br.readLine());
            if (cur == 0) {
                break;
            }

            sb.append(count);
            if (cur % 2 == 0) {
                cur = (((cur * 3) / 2) * 3) / 9;
                sb.append(". even ");
            } else {
                cur = ((((cur * 3) + 1) / 2) * 3) / 9;
                sb.append(". odd ");
            }
            sb.append(cur).append("\n");
            count++;
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}