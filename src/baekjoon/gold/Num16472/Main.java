package baekjoon.gold.Num16472;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] word = br.readLine().toCharArray();
        char[] alphabet = new char[26];
        int start = 0, end = 0, len = 0, answer = 0, cnt = 0;
        while (start <= end && end < word.length) {

            if (cnt <= N) { // 추가 가능할 떄
                len++;
                int cur = word[end] - 'a';
                if (alphabet[cur] == 0) {
                    cnt++;
                }
                alphabet[cur]++;

                end++;
            } else { // 추가 불가능 할 때
                int cur = word[start] - 'a';
                alphabet[cur]--;
                len--;
                if (alphabet[cur] == 0) {
                    cnt--;
                }
                start++;
            }

            if (cnt <= N) {
                answer = Math.max(len, answer);
            }
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}