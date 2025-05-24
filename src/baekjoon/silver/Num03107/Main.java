package baekjoon.silver.Num03107;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String address = br.readLine();
        if (!address.contains("::")) {
            for (String block : address.split(":")) {
                sb.append(String.format("%4s", block).replace(' ', '0'));
                sb.append(":");
            }
        } else {
            String[] parts = address.split("::", -1);
            String[] left = parts[0].isEmpty() ? new String[0] : parts[0].split(":");
            String[] right = !parts[1].isEmpty() ? parts[1].split(":") : new String[0];

            int blockSize = 8 - (left.length + right.length);
            for (String block : left) {
                sb.append(String.format("%4s", block).replace(' ', '0')).append(":");
            }
            sb.append("0000:".repeat(Math.max(0, blockSize)));

            for (String block : right) {
                sb.append(String.format("%4s", block).replace(' ', '0'));
                sb.append(":");
            }
        }

        sb.setLength(sb.length() - 1);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}