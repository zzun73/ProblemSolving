package baekjoon.silver.Num30611;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Set<String> set = new HashSet<>();
        int answer = 1;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while (N-- > 0) {
            set.add(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while (M-- > 0) {
            if (!set.contains(st.nextToken())) {
                answer = 0;
                break;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}