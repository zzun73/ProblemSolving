package baekjoon.silver.Num01543;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String word = br.readLine();

        str = str.replace(word, "A");
        int answer = 0;
        for (char c : str.toCharArray()) {
            if (c == 'A') {
                answer++;
            }
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
