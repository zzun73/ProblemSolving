package baekjoon.bronze.Num03181;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Set<String> set = new HashSet<>(Arrays.asList("i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili"));

        st = new StringTokenizer(br.readLine(), " ");
        boolean isFirst = true;
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            if (isFirst || !set.contains(word)) {
                sb.append(word.charAt(0));
            }
            isFirst = false;
        }

        bw.write(sb.toString().toUpperCase());

        br.close();
        bw.close();
    }
}