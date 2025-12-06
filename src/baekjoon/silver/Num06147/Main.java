package baekjoon.silver.Num06147;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            list.add(val);
        }
        list.sort(Collections.reverseOrder());

        int answer = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += list.get(i);
            if (sum >= B) {
                answer = i + 1;
                break;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}