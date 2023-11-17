package swea.d2.Num01946;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringBuilder path = new StringBuilder();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String alphabet = st.nextToken();
                int count = Integer.parseInt(st.nextToken());
                while (count-- > 0) {
                    path.append(alphabet);
                }
            }
            String str = path.toString();
            sb.append("#").append(t).append("\n");
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                if ((i + 1) % 10 == 0) {
                    sb.append("\n");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}