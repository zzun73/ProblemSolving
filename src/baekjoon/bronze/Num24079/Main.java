package baekjoon.bronze.Num24079;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int z = Integer.parseInt(br.readLine());

        int answer;
        if ((x + y) * 60 <= z * 60 + 30) {
            answer = 1;
        } else {
            answer = 0;
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}