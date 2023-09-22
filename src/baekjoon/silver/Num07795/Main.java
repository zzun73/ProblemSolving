package baekjoon.silver.Num07795;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[A];
            int[] arr2 = new int[B];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < A; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < B; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr2);

            int answer = 0;
            for (int target : arr1) {
                int left = 0;
                int right = arr2.length - 1;

                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (target <= arr2[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                answer += left;
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}