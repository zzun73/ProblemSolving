package baekjoon.silver.Num15723;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Character>[] list;
    static boolean[] visited;
    static char start, target;

    public static void helper(char start) {
        visited[start - 'a'] = true;

        if (visited[target - 'a']) {
            return;
        }

        for (char next : list[start - 'a']) {
            if (!visited[next - 'a']) {
                helper(next);
            }
        }
        visited[start - 'a'] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[26];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char start = st.nextToken().charAt(0);
            st.nextToken();
            char target = st.nextToken().charAt(0);
            list[start - 'a'].add(target);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            visited = new boolean[26];

            st = new StringTokenizer(br.readLine(), " ");
            start = st.nextToken().charAt(0);
            st.nextToken();
            target = st.nextToken().charAt(0);
            helper(start);
            sb.append(visited[target - 'a'] ? "T" : "F").append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
