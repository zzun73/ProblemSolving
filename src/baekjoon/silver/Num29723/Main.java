package baekjoon.silver.Num29723;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String key = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            map.put(key, value);
        }
        int max = 0;
        int min = 0;
        for (int i = 0; i < K; i++) {
            String key = br.readLine();
            min += map.get(key);
            max += map.get(key);
            map.remove(key);
        }
        List<Integer> collect = map.values().stream().sorted().collect(Collectors.toList());

        int count = M - K;
        for (int val : collect) {
            if (count-- < 1) {
                break;
            }
            min += val;
        }

        collect.sort(Comparator.reverseOrder());
        count = M - K;
        for (int val : collect) {
            if (count-- < 1) {
                break;
            }
            max += val;
        }
        sb.append(min).append(" ").append(max);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}