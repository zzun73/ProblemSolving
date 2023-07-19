package baekjoon.bronze.Num11328;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int[] freq = new int[26];
            st = new StringTokenizer(br.readLine(), " ");
            char[] ch1 = st.nextToken().toCharArray();
            char[] ch2 = st.nextToken().toCharArray();

            for (char ch : ch1) {
                freq[ch - 'a']++;
            }
            for (char ch : ch2) {
                freq[ch - 'a']--;
            }
            boolean flag = true;
            for (int val : freq) {
                if (val != 0) {
                    flag = false;
                    break;
                }
            }
            sb.append(flag ? "Possible" : "Impossible").append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
