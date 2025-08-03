package baekjoon.silver.Num29881;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, String> lastNameMap = new HashMap<>();
        Map<String, String> accountNameMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String key = st.nextToken();
            String value = st.nextToken();
            lastNameMap.put(key, value);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            String key = st.nextToken();
            String value = st.nextToken();
            accountNameMap.put(key, value);
        }

        for (String key : lastNameMap.keySet()) {
            sb.append(lastNameMap.get(key)).append(" ").append(accountNameMap.get(key)).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}