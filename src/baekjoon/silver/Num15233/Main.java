package baekjoon.silver.Num15233;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        HashSet<String> setA = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < A; i++) {
            setA.add(st.nextToken());
        }
        HashSet<String> setB = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < B; i++) {
            setB.add(st.nextToken());
        }

        int teamA = 0;
        int teamB = 0;
        st = new StringTokenizer(br.readLine(), " ");
        while (G-- > 0) {
            String player = st.nextToken();
            if (setA.contains(player)) {
                teamA++;
            } else if (setB.contains(player)) {
                teamB++;
            }
        }
        bw.write(teamA > teamB ? "A" : teamA < teamB ? "B" : "TIE");
        br.close();
        bw.flush();
        bw.close();
    }
}
