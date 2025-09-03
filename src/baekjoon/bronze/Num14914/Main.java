package baekjoon.bronze.Num14914;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int gcd(int x, int y) {
        while (y != 0) {
            int t = x % y;
            x = y;
            y = t;
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int g = gcd(a, b);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                list.add(i);
                if (i * i != g) {
                    list.add(g / i);
                }
            }
        }
        Collections.sort(list);

        for (int val : list) {
            sb.append(val).append(' ')
                    .append(a / val).append(" ")
                    .append(b / val).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}