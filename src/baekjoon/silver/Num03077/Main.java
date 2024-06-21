package baekjoon.silver.Num03077;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            map.put(st.nextToken(), i);
        }

        int answer = 0;
        st = new StringTokenizer((br.readLine()), " ");
        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            names[i] = st.nextToken();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (map.get(names[i]) < map.get(names[j])) {
                    answer++;
                }
            }
        }
        sb.append(answer).append("/").append((N * (N - 1)) / 2);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}