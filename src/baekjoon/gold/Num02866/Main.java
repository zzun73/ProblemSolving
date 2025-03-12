package baekjoon.gold.Num02866;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static String[] words;

    static int helper() {
        int result = 0;
        int left = 0;
        int right = R - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    static boolean check(int row) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < C; i++) {
            String str = words[i].substring(row);
            if (!set.add(str)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] input = new char[R][C];
        for (int i = 0; i < R; i++) {
            input[i] = br.readLine().toCharArray();
        }

        words = new String[C];
        for (int j = 0; j < C; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < R; i++) {
                sb.append(input[i][j]);
            }
            words[j] = sb.toString();
        }

        bw.write(String.valueOf(helper()));

        br.close();
        bw.close();
    }
}