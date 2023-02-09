package baekjoon.silver.Num10610;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        if (!N.contains("0")) {
            bw.write("-1");
        } else {
            StringBuilder sb = new StringBuilder();
            char[] nums = N.toCharArray();
            Arrays.sort(nums);
            int sum = 0;

            for (int i = nums.length - 1; i >= 0; i--) {
                sum += nums[i];
                sb.append(nums[i]);
            }

            if (sum % 3 == 0) {
                bw.write(sb.toString());
            } else {
                bw.write("-1");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
