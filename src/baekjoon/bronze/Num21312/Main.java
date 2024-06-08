package baekjoon.bronze.Num21312;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] arr = new int[3];
        boolean odd = false;
        int answer = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] % 2 != 0) {
                answer *= arr[i];
                odd = true;
            }
        }
        bw.write(String.valueOf(odd ? answer : arr[0] * arr[1] * arr[2]));

        br.close();
        bw.close();
    }
}