package baekjoon.silver.Num10824;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();
        long first = Long.parseLong(a + b);
        String c = st.nextToken();
        String d = st.nextToken();
        long second = Long.parseLong(c + d);

        bw.write(String.valueOf(first + second));

        br.close();
        bw.close();
    }
}