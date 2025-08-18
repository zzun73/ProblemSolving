package baekjoon.bronze.Num11800;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String[] dice1 = {"", "Yakk", "Doh", "Seh", "Ghar", "Bang", "Sheesh"};
        String[] dice2 = {"", "Habb Yakk", "Dobara", "Dousa", "Dorgy", "Dabash", "Dosh"};

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append("Case ").append(t).append(": ");
            if (a == b) {
                sb.append(dice2[a]).append("\n");
                continue;
            }

            int max = Math.max(a, b);
            int min = Math.min(a, b);
            if (max == 6 && min == 5) {
                sb.append("Sheesh Beesh").append("\n");
            } else {
                sb.append(dice1[max]).append(" ").append(dice1[min]).append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}