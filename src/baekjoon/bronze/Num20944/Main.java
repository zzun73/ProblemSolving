package baekjoon.bronze.Num20944;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        char[] arr = new char[num];

        Arrays.fill(arr, 'a');
        sb.append(arr);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}