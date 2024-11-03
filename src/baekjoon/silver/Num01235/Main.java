package baekjoon.silver.Num01235;

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String[] word = new String[N];
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; ++i) {
            word[i] = br.readLine();
        }

        for (int i = 1; i <= word[0].length(); ++i) {
            for (int j = 0; j < N; ++j) {
                set.add(word[j].substring(word[j].length() - i));
            }
            if (set.size() == N) {
                answer = i;
                break;
            }
            set.clear();
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}