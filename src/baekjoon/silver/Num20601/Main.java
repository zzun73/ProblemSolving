package baekjoon.silver.Num20601;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, HashSet<String>> map;

    static boolean helper(String a, String b) {
        if (a.equals(b)) {
            return true;
        }
        if (map.containsKey(a)) {
            for (String str : map.get(a)) {
                if (helper(str, b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String child = st.nextToken();
            String parent = st.nextToken();
            map.put(parent, map.getOrDefault(parent, new HashSet<>()));
            map.get(parent).add(child);
        }
        st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken();
        String b = st.nextToken();


        bw.write(String.valueOf(helper(a, b) || helper(b, a) ? 1 : 0));

        br.close();
        bw.close();
    }
}