package baekjoon.bronze.Num33845;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<Character> set = new HashSet<>();
        for (char ch : br.readLine().toCharArray()) {
            set.add(ch);
        }

        for (char ch : br.readLine().toCharArray()) {
            if (!set.contains(ch)) {
                sb.append(ch);
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}