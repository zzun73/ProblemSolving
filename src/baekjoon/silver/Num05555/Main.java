package baekjoon.silver.Num05555;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String target = br.readLine();
        int T = Integer.parseInt(br.readLine());
        int answer = 0;
        while (T-- > 0) {
            String str = br.readLine();
            sb.append(str).append(str);

            if (sb.toString().contains(target)) {
                answer++;
            }
            sb.setLength(0);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}