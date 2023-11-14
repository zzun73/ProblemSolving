package swea.d3.Num03499;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
            int mid;
            if (N % 2 == 1) {
                mid = N / 2 + 1;
            } else {
                mid = N / 2;
            }
            st = new StringTokenizer(br.readLine(), " ");
            List<String> odd = new ArrayList<>();
            List<String> even = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String str = st.nextToken();
                if (i < mid) {
                    odd.add(str);
                } else {
                    even.add(str);
                }
            }

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < even.size(); i++) {
                sb.append(odd.get(i)).append(" ").append(even.get(i)).append(" ");
            }
            if (N % 2 == 1) {
                sb.append(odd.get(odd.size() - 1));
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}