package baekjoon.bronze.Num23343;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        String x = st.nextToken(), y = st.nextToken();

        boolean isNumber = true;
        for (char c : x.toCharArray()) {
            if (!Character.isDigit(c)) {
                isNumber = false;
            }
        }
        for (char c : y.toCharArray()) {
            if (!Character.isDigit(c)) {
                isNumber = false;
            }
        }
        if (!isNumber) {
            bw.write("NaN");
        } else {
            bw.write(String.valueOf(Integer.parseInt(x) - Integer.parseInt(y)));
        }

        br.close();
        bw.close();
    }
}