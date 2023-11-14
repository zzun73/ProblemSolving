package swea.d3.Num04047;

import java.io.*;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            HashSet<String> set = new HashSet<>();
            String str = br.readLine();
            int[] answer = new int[]{13, 13, 13, 13};
            boolean isDuplicate =false;
            for (int i = 0; i < str.length(); i += 3) {
                String cur = str.substring(i, i + 3);
                if (!set.add(cur)) {
                    isDuplicate=true;
                    break;
                }
                switch (str.charAt(i)) {
                    case 'S':
                        answer[0]--;
                        break;
                    case 'D':
                        answer[1]--;
                        break;
                    case 'H':
                        answer[2]--;
                        break;
                    case 'C':
                        answer[3]--;
                        break;
                }
            }
            sb.append("#").append(t).append(" ");
            if (isDuplicate) {
                sb.append("ERROR");
            } else {
                for (int val : answer) {
                    sb.append(val).append(" ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}