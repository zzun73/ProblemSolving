package baekjoon.gold.Num02138;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, cur1Answer, cur2Answer;
    static String targetStr;
    static char[] cur1, cur2, target;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        cur1 = br.readLine().toCharArray();
        target = br.readLine().toCharArray();
        cur1Answer = 0;
        cur2Answer = 1;
        cur2 = cur1.clone();

        targetStr = Arrays.toString(target);
        // 배열이 같을 경우
        if (Arrays.toString(cur1).equals(targetStr)) {
            bw.write("0");
        } else {
            // 첫번째 누르고 시작
            cur2[0] = cur2[0] == '0' ? '1' : '0';
            cur2[1] = cur2[1] == '0' ? '1' : '0';


            for (int i = 1; i < N - 1; i++) {
                if (cur2[i - 1] != target[i - 1]) {
                    for (int j = i - 1; j <= i + 1; j++) {
                        cur2[j] = cur2[j] == '0' ? '1' : '0';
                    }
                    cur2Answer++;
                }

                if (cur1[i - 1] != target[i - 1]) {
                    for (int j = i - 1; j <= i + 1; j++) {
                        cur1[j] = cur1[j] == '0' ? '1' : '0';
                    }
                    cur1Answer++;
                }
            }

            //마지막 누를지 검사
            if (cur2[N - 1] != target[N - 1]) {
                for (int j = N - 2; j <= N - 1; j++) {
                    cur2[j] = cur2[j] == '0' ? '1' : '0';
                }
                cur2Answer++;
            }
            if (cur1[N - 1] != target[N - 1]) {
                for (int j = N - 2; j <= N - 1; j++) {
                    cur1[j] = cur1[j] == '0' ? '1' : '0';
                }
                cur1Answer++;

            }

            if (!Arrays.toString(cur1).equals(targetStr)) {
                cur1Answer = Integer.MAX_VALUE;
            }
            if (!Arrays.toString(cur2).equals(targetStr)) {
                cur2Answer = Integer.MAX_VALUE;
            }

            bw.write(String.valueOf(cur1Answer == Integer.MAX_VALUE && cur2Answer == Integer.MAX_VALUE ? -1
                    : Math.min(cur1Answer, cur2Answer)));
        }

        br.close();
        bw.close();
    }
}