package baekjoon.silver.Num09996;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] target = br.readLine().split("\\*");
        while (N-- > 0) {
            String str = br.readLine();

            if (str.length() < target[0].length() + target[1].length()) {
                sb.append("NE").append("\n");
                continue;
            }

            if (str.startsWith(target[0]) && str.endsWith(target[1])) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}