package swea.d3.Num03131;

import java.io.*;

public class Solution {
    static boolean[] checked;

    public static void helper() {
        checked[0] = checked[1] = true;
        for (int i = 2; i < Math.sqrt(checked.length); i++) {
            if (checked[i]) {
                continue;
            }

            for (int j = i * i; j < checked.length; j+=i) {
                checked[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        checked = new boolean[1_000_001];

        helper();
        for (int i = 1; i < checked.length; i++) {
            if (!checked[i]) {
                sb.append(i).append(" ");
            }
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}