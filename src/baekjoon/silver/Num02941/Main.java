package baekjoon.silver.Num02941;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        int answer = 0;

        for (int i = 0; i < length; i++) {
            char word = str.charAt(i);

            if (word == 'c' && i < length - 1) {
                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++;
                }
            } else if (word == 'd' && i < length - 1) {
                if (str.charAt(i + 1) == '-') {
                    i++;
                } else if (str.charAt(i + 1) == 'z' && i < length - 2) {

                    if (str.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }
            } else if ((word == 'l' || word == 'n') && i < length - 1) {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            } else if ((word == 's' || word == 'z') && i < length - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            }

            answer++;
        }

        System.out.println(answer);
        br.close();
    }
}