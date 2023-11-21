package swea.d3.Num06190;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int[] arr;

    public static boolean helper(int val) {
        char[] chars = Integer.toString(val).toCharArray();

        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] > chars[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int answer = -1;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int cur = arr[i] * arr[j];
                    if (helper(cur)) {
                        answer = Math.max(answer, cur);
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}