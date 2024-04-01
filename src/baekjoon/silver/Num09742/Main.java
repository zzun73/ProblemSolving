package baekjoon.silver.Num09742;

import java.io.*;
import java.util.*;

public class Main {
    static String answer;
    static char[] words, temp;
    static boolean[] visited;
    static int position, len, count;

    static void helper(int depth) {
        if (depth == len) {
            if (++count == position) {
                StringBuilder ans = new StringBuilder();
                for (char c : temp) {
                    ans.append(c);
                }
                answer = ans.toString();
            }
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[depth] = words[i];
                helper(depth + 1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input, " ");
            String str = st.nextToken();
            words = str.toCharArray();
            position = Integer.parseInt(st.nextToken());

            len = words.length;
            Arrays.sort(words);
            temp = new char[len];
            visited = new boolean[len];
            count = 0;
            answer = "No permutation";

            helper(0);

            sb.append(str).append(" ").append(position).append(" ").append("=").append(" ")
                    .append(answer).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}