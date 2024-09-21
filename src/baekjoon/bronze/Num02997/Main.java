package baekjoon.bronze.Num02997;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] arr = new int[3];
        st = new StringTokenizer(br.readLine(), " ");
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int first = arr[1] - arr[0];
        int second = arr[2] - arr[1];

        if (first == second) {
            sb.append(arr[2] + first);
        } else if (first < second) {
            sb.append(arr[1] + first);
        } else {
            sb.append(arr[0] + second);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}