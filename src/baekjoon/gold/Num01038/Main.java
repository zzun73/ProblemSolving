package baekjoon.gold.Num01038;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static List<Long> path;

    public static void helper(long num) {
        path.add(num);
        long modValue = num % 10;
        if (modValue == 0) {
            return;
        }

        for (long i = modValue - 1; i >= 0; i--) {
            long newValue = num * 10 + i;
            helper(newValue);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        if (N <= 10) {
            System.out.print(N);
            return;
        } else if (N >= 1023) {
            System.out.println(-1);
            return;
        } else {
            path = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                helper(i);
            }
            Collections.sort(path);
            System.out.print(path.get(N));
        }

        br.close();
    }
}
