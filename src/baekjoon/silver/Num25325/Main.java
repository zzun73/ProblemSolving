package baekjoon.silver.Num25325;

import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    String key;
    int value;

    public Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.value == o.value) {
            return this.key.compareTo(o.key);
        }
        return o.value - this.value;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            map.put(st.nextToken(), 0);
        }

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                String key = st.nextToken();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        List<Pair> pairs = new ArrayList<>();
        for (String key : map.keySet()) {
            pairs.add(new Pair(key, map.get(key)));
        }
        Collections.sort(pairs);

        for (Pair pair : pairs) {
            sb.append(pair.key).append(" ").append(pair.value).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}