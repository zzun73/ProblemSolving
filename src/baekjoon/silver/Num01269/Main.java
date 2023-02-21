package baekjoon.silver.Num01269;

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
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> A = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        while (N-- > 0) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        HashSet<Integer> B = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        while (M-- > 0) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        HashSet<Integer> aSub = new HashSet<>(A);
        A.removeAll(B);
        B.removeAll(aSub);
        A.addAll(B);

        bw.write(A.size() + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
