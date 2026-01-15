package baekjoon.bronze.Num02386;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("#")) {
                break;
            }

            st = new StringTokenizer(line, " ");
            String target = st.nextToken();

            int count = 0;
            while (st.hasMoreTokens()) {
                String str = st.nextToken().toLowerCase();
                int len = str.length();
                count += len - str.replaceAll(target, "").length();
            }
            sb.append(target).append(" ").append(count).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}