package swea.d3.Num06808;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static final int SIZE = 9;
    static int answer;
    static int[] arr, brr, path;
    static boolean[] visited;

    public static void helper(int idx) {
        if (idx == SIZE) {
            int aSum = 0, bSum = 0;

            for (int i = 0; i < SIZE; i++) {
                if (arr[i] > path[i]) {
                    aSum += arr[i] + path[i];
                } else {
                    bSum += arr[i] + path[i];
                }
            }
            if (aSum > bSum) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < brr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path[idx] = brr[i];
                helper(idx + 1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            boolean[] card = new boolean[19];
            arr = new int[SIZE];
            brr = new int[SIZE];
            path = new int[SIZE];
            visited = new boolean[SIZE];
            answer = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < SIZE; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                card[arr[i]] = true;
            }

            int idx = 0;
            for (int i = 1; i < card.length; i++) {
                if (!card[i]) {
                    brr[idx++] = i;
                }
            }
            helper(0);

            sb.append("#").append(t).append(" ").append(answer).append(" ").append(362880 - answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}