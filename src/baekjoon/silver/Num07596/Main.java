package baekjoon.silver.Num07596;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int num = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            List<String> list = new ArrayList<>();

            while (N-- > 0) {
                list.add(br.readLine());
            }

            Collections.sort(list);

            sb.append(num++).append("\n");
            for (String str : list) {
                sb.append(str).append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}