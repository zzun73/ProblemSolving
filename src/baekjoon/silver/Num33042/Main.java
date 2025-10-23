package baekjoon.silver.Num33042;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            String key = st.nextToken();
            map.put(key, map.getOrDefault(key, 0) + 1);
            if (map.get(key) == 5) {
                answer = i;
                break;
            }
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}