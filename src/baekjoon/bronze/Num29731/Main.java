package baekjoon.bronze.Num29731;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = {"Never gonna give you up",
                "Never gonna let you down",
                "Never gonna run around and desert you",
                "Never gonna make you cry",
                "Never gonna say goodbye",
                "Never gonna tell a lie and hurt you",
                "Never gonna stop"};
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            String b = br.readLine();
            for (String s : str) {
                if (b.equals(s)) {
                    count++;
                    break;
                }
            }
        }

        bw.write(count != N ? "Yes" : "No");

        br.close();
        bw.close();
    }
}