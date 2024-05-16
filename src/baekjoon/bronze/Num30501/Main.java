package baekjoon.bronze.Num30501;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        String answer = "";
        for (int i = 0; i < num; i++) {
            String str = br.readLine();

            if (str.contains("S")) {
                answer = str;
                break;
            }
        }
        bw.write(answer);

        br.close();
        bw.close();
    }
}