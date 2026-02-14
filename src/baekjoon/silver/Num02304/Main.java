package baekjoon.silver.Num02304;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            arr[L] = H;
            if (maxHeight < H) {
                maxHeight = H;
                maxIdx = L;
            }
            left = Math.min(left, L);
            right = Math.max(right, L);
        }

        int answer = arr[maxIdx];
        int cur = arr[left];
        for (int i = left; i < maxIdx; i++) {
            cur = Math.max(arr[i], cur);
            answer += cur;
        }

        cur = arr[right];
        for (int i = right; i > maxIdx; i--) {
            cur = Math.max(arr[i], cur);
            answer += cur;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}