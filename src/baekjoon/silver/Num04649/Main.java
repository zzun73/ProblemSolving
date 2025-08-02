package baekjoon.silver.Num04649;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }

            Set<Character> in = new HashSet<>();
            Set<Character> out = new HashSet<>();
            int answer = 0;

            for (char ch : st.nextToken().toCharArray()) {
                if (in.contains(ch)) {
                    in.remove(ch);
                } else if (out.contains(ch)) {
                    continue;
                } else {
                    if (in.size() < N) {
                        in.add(ch);
                    } else {
                        answer++;
                        out.add(ch);
                    }
                }
            }

            if (answer == 0) {
                sb.append("All customers tanned successfully.").append("\n");
            } else {
                sb.append(answer).append(" customer(s) walked away.").append("\n");
            }
        }


        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}