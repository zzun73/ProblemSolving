package baekjoon.silver.Num01431;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static int sumOfNum(String o) {
        int sum = 0;
        for (int i = 0; i < o.length(); i++) {
            int cur = o.charAt(i) - '0';
            if (1 <= cur && cur <= 9) {
                sum += cur;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        Arrays.sort(str, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                int sum1, sum2;
                sum1 = sumOfNum(o1);
                sum2 = sumOfNum(o2);

                return sum1 == sum2 ? o1.compareTo(o2) : sum1 - sum2;
            }
        });

        for (String s : str) {
            sb.append(s).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}