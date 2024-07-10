package baekjoon.bronze.Num30999;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            int count = 0;

            for (int j = 0; j < m; j++) {
                if (arr[j] == 'O') {
                    count++;
                }
            }
            if (count > m / 2) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}