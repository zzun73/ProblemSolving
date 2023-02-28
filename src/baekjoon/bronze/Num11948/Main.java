package baekjoon.bronze.Num11948;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int temp = Integer.parseInt(br.readLine());
        int answer = temp;

        for (int i = 0; i < 3; i++) {
            int val = Integer.parseInt(br.readLine());
            answer += val;
            temp = Math.min(val, temp);
        }
        answer -= temp;
        temp = Integer.parseInt(br.readLine());
        temp = Math.max(Integer.parseInt(br.readLine()), temp);
        answer += temp;

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
