package baekjoon.silver.Num01251;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        List<String> list = new ArrayList<>();
        for (int i = 2; i < str.length(); i++) {
            for (int j = 1; j < i; j++) {
                StringBuilder first = new StringBuilder(str.substring(0, j));
                StringBuilder second = new StringBuilder(str.substring(j, i));
                StringBuilder third = new StringBuilder(str.substring(i));
                first.reverse();
                second.reverse();
                third.reverse();
                first.append(second).append(third);
                list.add(first.toString());
            }
        }
        Collections.sort(list);
        bw.write(list.get(0));

        br.close();
        bw.close();
    }
}