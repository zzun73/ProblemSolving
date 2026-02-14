package baekjoon.silver.Num09536;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] str = br.readLine().split(" ");

            Set<String> set = new HashSet<>();
            while (true) {
                String input = br.readLine();
                if (input.equals("what does the fox say?")) {
                    break;
                }

                String word = input.split(" ")[input.split(" ").length - 1];
                set.add(word);
            }

            for (String s : str) {
                if (!set.contains(s)) {
                    sb.append(s).append(" ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}