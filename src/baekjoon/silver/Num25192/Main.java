package baekjoon.silver.Num25192;

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        while (N-- > 0) {
            String cur = br.readLine();
            if (cur.equals("ENTER")) {
                set.clear();
                continue;
            }
            if (!set.contains(cur)) {
                set.add(cur);
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}