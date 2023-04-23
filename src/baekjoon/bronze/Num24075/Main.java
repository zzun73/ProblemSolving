package baekjoon.bronze.Num24075;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int sum = A + B;
        int sub = A - B;
        bw.write(sum > sub ? sum + "\n" + sub : sub + "\n" + sum);

        br.close();
        bw.flush();
        bw.close();
    }
}
