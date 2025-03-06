package baekjoon.silver.Num09575;

import java.io.*;
import java.util.*;

public class Main {

    static boolean isLucky(int num) {
        while (num != 0) {
            if (num % 10 != 5 && num % 10 != 8)
                return false;
            num /= 10;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            List<Integer>[] list = new ArrayList[3];
            for (int i = 0; i < 3; i++) {
                int N = Integer.parseInt(br.readLine());
                list[i] = new ArrayList<>();
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    list[i].add(val);
                }
            }
            Set<Integer> set = new HashSet<>();
            for (int a : list[0]) {
                for (int b : list[1]) {
                    for (int c : list[2]) {
                        int sum = a + b + c;
                        if (isLucky(sum)) {
                            set.add(sum);
                        }
                    }
                }
            }
            sb.append(set.size()).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}