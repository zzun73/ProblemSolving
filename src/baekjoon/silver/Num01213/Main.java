package baekjoon.silver.Num01213;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        int[] alphabet = new int[26];
        for (char c : input) {
            alphabet[c - 'A']++;
        }

        boolean isOne = false;
        int mid = -1;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] % 2 == 1) {
                if (isOne) {
                    sb.append("I'm Sorry Hansoo");
                    break;
                }
                isOne = true;
                mid = i;
            }

            while (alphabet[i] >= 2) {
                front.append((char) (i + 'A'));
                back.append((char) (i + 'A'));
                alphabet[i] -= 2;
            }
        }

        if (sb.length() == 0) {
            if (mid != -1) {
                front.append((char) (mid + 'A'));
            }
            String str = front.append(back.reverse()).toString();
            sb.append(str);
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}