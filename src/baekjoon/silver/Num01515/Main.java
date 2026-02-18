package baekjoon.silver.Num01515;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int index = 0;
        for (int i = 1; ; i++) {
            String target = String.valueOf(i);

            for (int j = 0; j < target.length(); j++) {
                if (input.charAt(index) == target.charAt(j)) {
                    index++;

                    if (index == input.length()) {
                        bw.write(String.valueOf(i));
                        br.close();
                        bw.flush();
                        return;
                    }
                }
            }
        }

    }
}