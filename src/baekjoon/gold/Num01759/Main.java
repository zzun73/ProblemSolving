package baekjoon.gold.Num01759;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] password;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static List<Character> path;

    public static void helper(int depth, int start) {
        if (depth == L) {
            if (isValid()) {
                for (char c : path) {
                    sb.append(c);
                }
                sb.append("\n");
            }
        }

        for (int i = start; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(password[i]);
                helper(depth + 1, i + 1);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static boolean isValid() {
        int mo = 0;
        int ja = 0;

        for (char c : path) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        password = new char[C];
        visited = new boolean[C];
        path = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            password[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(password);
        helper(0, 0);

        System.out.println(sb);
        br.close();
    }
}
