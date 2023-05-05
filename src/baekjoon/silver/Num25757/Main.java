package baekjoon.silver.Num25757;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        String mode = st.nextToken();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int people = mode.equals("Y") ? 1 : (mode.equals("F") ? 2 : 3);
        bw.write(set.size() / people + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
