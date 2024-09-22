package baekjoon.silver.Num16524;

import java.io.*;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;

        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        while (N-- > 0) {
            String[] input = br.readLine().split("@");
            int index = input[0].indexOf("+");
            if (index >= 0) {
                input[0] = input[0].substring(0, index);
            }
            input[0] = input[0].replaceAll("\\.", "");

            sb = new StringBuilder();
            sb.append(input[0]).append(input[1]);
            set.add(sb.toString());
        }
        bw.write(String.valueOf(set.size()));

        br.close();
        bw.close();
    }
}