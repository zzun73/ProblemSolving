package baekjoon.silver.Num28445;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        List<String> mother = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            mother.add(st.nextToken());
            mother.add(st.nextToken());
        }

        List<String> father = new ArrayList<>(mother);
        Set<String> set = new TreeSet<>();
        for (String m : mother) {
            for (String f : father) {
                set.add(String.format("%s %s", m, f));
            }
        }

        for (String val : set) {
            sb.append(val).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}