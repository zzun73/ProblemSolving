package baekjoon.bronze.Num11367;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static String helper(int s) {
        if (s >= 97) return "A+";
        else if (s >= 90) return "A";
        else if (s >= 87) return "B+";
        else if (s >= 80) return "B";
        else if (s >= 77) return "C+";
        else if (s >= 70) return "C";
        else if (s >= 67) return "D+";
        else if (s >= 60) return "D";
        else return "F";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            sb.append(name).append(' ').append(helper(score)).append("\n");
        }


        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}