package baekjoon.bronze.Num27159;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[36];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        int answer = 0;
        for (int i = 3; i < arr.length; i++) {
            if (arr[i - 1] == 0 && arr[i] != 0)
                answer += i;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}