package baekjoon.bronze.Num32209;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int Q = Integer.parseInt(br.readLine());
        int problems = 0;

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int type = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if (type == 1) {
                problems += value;
            } else {
                if (problems < value) {
                    bw.write("Adios");
                    bw.close();
                    return;
                }
                problems -= value;
            }
        }


        bw.write("See you next month");

        br.close();
        bw.close();
    }
}