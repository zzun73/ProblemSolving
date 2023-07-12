package baekjoon.bronze.Num15873;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String str = br.readLine();
        int answer;
        if (str.length() == 4) {
            answer = 20;
        } else if (str.contains("10")) {
            str = str.replace("10", "");
            answer = 10 + Integer.parseInt(str);
        } else {
            answer = str.charAt(0) - '0' + str.charAt(1) - '0';
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
