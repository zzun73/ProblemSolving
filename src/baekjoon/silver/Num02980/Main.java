package baekjoon.silver.Num02980;

import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int D = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            arr[i][0] = D;
            arr[i][1] = R;
            arr[i][2] = G;
        }

        int pos = 0;
        int time = 0;
        int idx = 0;
        while (pos != L) {
            if (idx < N && arr[idx][0] == pos) {
                int temp = time % (arr[idx][1] + arr[idx][2]);
                if (temp < arr[idx][1]) {
                    time += arr[idx][1] - temp;
                }
                idx++;
            }
            pos++;
            time++;
        }
        bw.write(String.valueOf(time));

        br.close();
        bw.flush();
        bw.close();
    }
}