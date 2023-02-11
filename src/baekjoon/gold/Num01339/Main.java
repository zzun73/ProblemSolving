package baekjoon.gold.Num01339;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            str[i] = st.nextToken();
            for (int j = 0; j < str[i].length(); j++) {
                char key = str[i].charAt(j);
                map.put(key, map.getOrDefault(key, 0) + (int) Math.pow(10, str[i].length() - j - 1));
            }
        }

        List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        int answer = 0;
        int number = 9;
        for (Map.Entry<Character, Integer> entry : list) {
            answer += entry.getValue() * number;
            number--;
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
