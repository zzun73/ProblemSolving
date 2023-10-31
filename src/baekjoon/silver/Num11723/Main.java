package baekjoon.silver.Num11723;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int x = 0;
            if (!(command.equals("all") || command.equals("empty"))) {
                x = Integer.parseInt(st.nextToken());
            }
            switch (command) {
                case "add":
                    set.add(x);
                    break;
                case "remove":
                    set.remove(x);
                    break;
                case "check":
                    bw.write(set.contains(x) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    boolean garbage = set.contains(x) ? set.remove(x) : set.add(x);
                    break;
                case "all":
                    set.clear();
                    for (int i = 1; i <= 20; i++) {
                        set.add(i);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }

        }

        br.close();
        bw.flush();
        bw.close();
    }
}
