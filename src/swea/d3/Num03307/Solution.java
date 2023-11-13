package swea.d3.Num03307;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int[] arr;
    static List<Integer> lis;

    public static void helper(int target) {
        int left = 0;
        int right = lis.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (lis.get(mid) == target) {
                return;
            } else if (lis.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        lis.set(left, target);
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
            lis = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            lis.add(arr[0]);
            for (int i = 1; i < N; i++) {
                int cur = arr[i];
                if (cur > lis.get(lis.size() - 1)) {
                    lis.add(cur);
                } else {
                    helper(cur);
                }
            }
            sb.append("#").append(t).append(" ").append(lis.size()).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}