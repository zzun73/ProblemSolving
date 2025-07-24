package baekjoon.gold.Num02357;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int offset;
    static int[] minTree, maxTree;

    static class Result {
        int minValue, maxValue;

        public Result(int minValue, int maxValue) {
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }

    static Result query(int l, int r) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        int start = offset + l;
        int end = offset + r;

        while (start <= end) {
            if ((start & 1) == 1) {
                minValue = Math.min(minValue, minTree[start]);
                maxValue = Math.max(maxValue, maxTree[start]);
                start++;
            }

            if ((end & 1) == 0) {
                minValue = Math.min(minValue, minTree[end]);
                maxValue = Math.max(maxValue, maxTree[end]);
                end--;
            }
            start /= 2;
            end /= 2;
        }

        return new Result(minValue, maxValue);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        offset = 1;
        while (offset < N) {
            offset *= 2;
        }
        minTree = new int[offset * 2 + 2];
        maxTree = new int[offset * 2 + 2];

        Arrays.fill(minTree, Integer.MAX_VALUE);
        Arrays.fill(maxTree, Integer.MIN_VALUE);

        for (int i = 0; i < N; i++) {
            minTree[i + offset] = maxTree[i + offset] = Integer.parseInt(br.readLine());
        }

        for (int i = offset - 1; i >= 1; i--) {
            minTree[i] = Math.min(minTree[i * 2], minTree[i * 2 + 1]);
            maxTree[i] = Math.max(maxTree[i * 2], maxTree[i * 2 + 1]);
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Result result = query(a-1, b-1);
            sb.append(result.minValue).append(" ").append(result.maxValue).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}