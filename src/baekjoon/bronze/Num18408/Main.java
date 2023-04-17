package baekjoon.bronze.Num18408;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] arr = new int[3];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[val]++;
        }
        bw.write(arr[1] > arr[2] ? "1" : "2");

        br.close();
        bw.flush();
        bw.close();
    }
}
