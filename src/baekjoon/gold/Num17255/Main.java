package baekjoon.gold.Num17255;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static char[] ch;
    static Set<String> set;

    public static void helper(int L, int R, String str, String path) {
        if (L == 0 && R == ch.length - 1) {
            set.add(path);
            return;
        }
        
        if (L - 1 >= 0) {
            helper(L - 1, R, ch[L - 1] + str, path + " -> " + ch[L - 1] + str);
        }
        if (R + 1 < ch.length) {
            helper(L, R + 1, str + ch[R + 1], path + " -> " + str + ch[R + 1]);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        ch = st.nextToken().toCharArray();
        set = new HashSet<>();
        for (int i = 0; i < ch.length; i++) {
            helper(i, i, "" + ch[i], "" + ch[i]);
        }
        System.out.println(set.size());

        br.close();
    }
}
