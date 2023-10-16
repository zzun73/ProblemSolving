package baekjoon.silver.Num15720;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int[] itemCount = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[][] items = new int[3][];
        int originalPrice = 0;

        for (int i = 0; i < 3; i++) {
            items[i] = new int[itemCount[i]];
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < itemCount[i]; j++) {
                items[i][j] = Integer.parseInt(st.nextToken());
                originalPrice += items[i][j];
            }
            Arrays.sort(items[i]);
        }

        int discountPrice = 0;
        int[] idx = {itemCount[0] - 1, itemCount[1] - 1, itemCount[2] - 1};
        while (idx[0] >= 0 && idx[1] >= 0 && idx[2] >= 0) {
            discountPrice += (items[0][idx[0]--] + items[1][idx[1]--] + items[2][idx[2]--]) * 9 / 10;
        }

        for (int i = 0; i < 3; i++) {
            while (idx[i] >= 0) {
                discountPrice += items[i][idx[i]];
                idx[i]--;
            }
        }

        sb.append(originalPrice).append("\n").append(discountPrice);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
