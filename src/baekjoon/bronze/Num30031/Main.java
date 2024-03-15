package baekjoon.bronze.Num30031;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(136, 1000);
        map.put(142, 5000);
        map.put(148, 10000);
        map.put(154, 50000);

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int width = Integer.parseInt(st.nextToken());
            st.nextToken();
            answer += map.get(width);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}