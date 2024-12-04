package baekjoon.silver.Num13414;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        LinkedHashSet<String> set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            String key = br.readLine();
            set.remove(key);
            set.add(key);
        }

        for (String key : set) {
            sb.append(key).append("\n");
            if (--N == 0) {
                break;
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}