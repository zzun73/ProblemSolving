package baekjoon.bronze.Num26531;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= 2; i++) {
            st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }
        String answer = arr[0] + arr[1] == arr[2] ? "YES" : "NO";
        bw.write(answer);

        br.close();
        bw.flush();
        bw.close();
    }
}
