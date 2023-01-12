package baekjoon.silver.Num01181;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            str[i] = st.nextToken();
        }

        Arrays.sort(str, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        });

        bw.write(str[0]+"\n");
        for (int i = 1; i < N; i++) {
            if (!str[i].equals(str[i - 1])) {
                bw.write(str[i]+"\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
