package baekjoon.silver.Num06296;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int NC = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        Set<String> set = new HashSet<>();

        for (int i = 0; i <= str.length() - N; i++) {
            set.add(str.substring(i, i + N));
        }

        bw.write(String.valueOf(set.size()));

        br.close();
        bw.close();
    }
}