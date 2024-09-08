package baekjoon.bronze.Num31822;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String code = br.readLine().substring(0, 5);
        String str;

        int answer = 0;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            str = br.readLine().substring(0, 5);

            if (code.equals(str)) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}