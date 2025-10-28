package baekjoon.silver.Num12873;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int step = 1;
        int index = 0;
        while (list.size() > 1) {
            long temp = (long) Math.pow(step, 3) - 1;
            index = (int) ((index + temp) % list.size());
            list.remove(index);
            step++;
        }

        bw.write(String.valueOf(list.get(0)));

        br.close();
        bw.close();
    }
}