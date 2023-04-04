package baekjoon.bronze.Num17388;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] arr = new int[3];
        String[] answer = new String[]{"Soongsil", "Korea", "Hanyang", "OK"};
        st = new StringTokenizer(br.readLine(), " ");
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
            sum += arr[i];
        }
        if (sum >= 100) {
            bw.write(answer[answer.length - 1]);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == min) {
                    bw.write(answer[i]);
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
