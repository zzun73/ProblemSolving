package baekjoon.silver.Num19637;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] str = new String[N];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            str[i] = st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (M-- > 0) {
            int target = Integer.parseInt(br.readLine());

            int start = 0;
            int end = N;
            while (start < end) {
                int mid = (start + end) / 2;

                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            sb.append(str[end]).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}