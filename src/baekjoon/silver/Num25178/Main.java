package baekjoon.silver.Num25178;

import java.io.*;

public class Main {
    static int N;
    static char[] original, other;

    static boolean first() {
        int[] count = new int[26];
        for (int i = 0; i < N; i++) {
            count[original[i] - 'a']++;
            count[other[i] - 'a']--;
        }
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }

    static boolean second() {
        return original[0] == other[0] && original[N - 1] == other[N - 1];
    }

    static boolean third() {
        String originalString = new String(original).replaceAll("[aeiou]", "");
        String otherString = new String(other).replaceAll("[aeiou]", "");
        return originalString.equals(otherString);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        original = br.readLine().toCharArray();
        other = br.readLine().toCharArray();


        bw.write((first() && second() && third()) ? "YES" : "NO");

        br.close();
        bw.close();
    }
}