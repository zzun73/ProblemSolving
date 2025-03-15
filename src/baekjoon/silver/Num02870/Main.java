package baekjoon.silver.Num02870;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<BigInteger> list = new ArrayList<>();
        while (N-- > 0) {
            String line = br.readLine();
            String[] str = line.split("\\D+");

            for (String s : str) {
                if (!s.isEmpty()) {
                    list.add(new BigInteger(s));
                }
            }
        }

        Collections.sort(list);
        for (BigInteger val : list) {
            sb.append(val).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}