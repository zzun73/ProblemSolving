package swea.d3.Num07728;

import java.io.*;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        HashSet<Character> set = new HashSet<>();
        for (int t = 1; t <= T; t++) {
            char[] input = br.readLine().toCharArray();
            for (char c : input) {
                set.add(c);
            }
            sb.append("#").append(t).append(" ").append(set.size()).append("\n");
            set.clear();
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}