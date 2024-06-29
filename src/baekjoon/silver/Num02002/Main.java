package baekjoon.silver.Num02002;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            map.put(br.readLine(), i);
        }

        int[] arrive = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            String cur = br.readLine();
            arrive[i] = map.get(cur);
        }

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (arrive[i] > arrive[j]) {
                    answer++;
                    break;
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
