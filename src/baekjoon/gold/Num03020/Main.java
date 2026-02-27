package baekjoon.gold.Num03020;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        List<Integer> bottom = new ArrayList<>();
        List<Integer> top = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                bottom.add(h);
            } else {
                top.add(h);
            }
        }

        Collections.sort(bottom);
        Collections.sort(top);

        int answerCount = Integer.MAX_VALUE;
        int answerArea = 0;
        for (int h = 1; h <= H; h++) {
            int start = 0;
            int end = bottom.size();
            while (start < end) {
                int mid = (start + end) / 2;

                if (bottom.get(mid) >= h) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            int bottomCount = bottom.size() - start;

            start = 0;
            end = top.size();
            while (start < end) {
                int mid = (start + end) / 2;

                if (top.get(mid) >= H - h + 1) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            int topCount = top.size() - start;

            int sumCount = bottomCount + topCount;
            if (sumCount < answerCount) {
                answerCount = sumCount;
                answerArea = 1;
            } else if (sumCount == answerCount) {
                answerArea++;
            }
        }

        sb.append(answerCount).append(" ").append(answerArea);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}