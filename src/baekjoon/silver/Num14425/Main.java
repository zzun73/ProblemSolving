package baekjoon.silver.Num14425;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        HashSet<String> set = new HashSet<>();

        int N = Integer.parseInt(st.nextToken());
        while (N-- > 0) {
            set.add(br.readLine());
        }

        int answer = 0;
        int M = Integer.parseInt(st.nextToken());
        while (M-- > 0) {
            if (set.contains(br.readLine())) {
                answer++;
            }
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
