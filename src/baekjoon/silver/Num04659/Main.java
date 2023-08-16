package baekjoon.silver.Num04659;

import java.io.*;

public class Main {
    static String input;

    public static boolean checked1() {
        char prev = ' ';
        int moCnt = 0, jaCnt = 0;
        boolean moFlag = false;
        for (char c : input.toCharArray()) {
            if (prev == c && c != 'e' && c != 'o') {
                return false;
            }
            prev = c;
            if (checked2(c)) {
                moFlag = true;
                moCnt += 1;
                jaCnt = 0;
            } else {
                jaCnt += 1;
                moCnt = 0;
            }

            if (moCnt == 3 || jaCnt == 3) {
                return false;
            }
        }
        return moFlag;
    }

    public static boolean checked2(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            if (checked1()) {
                sb.append("<").append(input).append("> is acceptable.").append("\n");
            } else {
                sb.append("<").append(input).append("> is not acceptable.").append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
