package baekjoon.silver.Num24793;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        String first = br.readLine();
        set.add(first);
        char ch = first.charAt(first.length() - 1);
        int player = -1;
        for (int i = 1; i < N; i++) {
            String cur = br.readLine();
            if (set.contains(cur) || cur.charAt(0) != ch) {
                player = i % 2 + 1;
                break;
            }
            set.add(cur);
            ch = cur.charAt(cur.length() - 1);
        }
        if (player == -1) {
            sb.append("Fair Game");
        } else {
            sb.append("Player").append(" ").append(player).append(" ").append("lost");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}