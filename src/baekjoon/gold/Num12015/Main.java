package baekjoon.gold.Num12015;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static List<Integer> list;

    public static void helper(int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) == target) {
                return;
            } else if (list.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        list.set(left, target);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        list.add(arr[0]);
        for (int i = 1; i < N; i++) {
            int cur = arr[i];
            if (list.get(list.size() - 1) < cur) {
                list.add(cur);
            } else {
                helper(cur);
            }
        }
        bw.write(String.valueOf(list.size()));

        br.close();
        bw.flush();
        bw.close();
    }
}