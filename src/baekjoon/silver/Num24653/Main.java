package baekjoon.silver.Num24653;

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<Long> set = new HashSet<>();
        String[]str =  br.readLine().split(" ");
        int T = Integer.parseInt(br.readLine());
        for (String s : str) {
            set.add(Long.parseLong(s) / T);
        }

        bw.write(String.valueOf(set.size()));

        br.close();
        bw.close();
    }
}