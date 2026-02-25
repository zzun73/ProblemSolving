package baekjoon.silver.Num04775;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<String> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            List<String> list = new ArrayList<>();
            String input;
            while (!(input = br.readLine()).equals("-1")) {
                if (!set.contains(input)) {
                    list.add(input);
                }
            }
            sb.append("Email ").append(i);
            if (list.isEmpty()) {
                sb.append(" is spelled correctly.");
            } else {
                sb.append(" is not spelled correctly.");
            }
            sb.append("\n");

            for (String s : list) {
                sb.append(s).append("\n");
            }
        }
        sb.append("End of Output");

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}