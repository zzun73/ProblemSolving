package baekjoon.gold.Num07662;

import java.io.*;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                char command = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (command == 'I') {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else if (command == 'D') {
                    if (!map.isEmpty()) {
                        if (n == 1) {
                            if (map.get(map.firstKey()) == 1) {
                                map.remove(map.firstKey());
                            } else {
                                map.put(map.firstKey(), map.get(map.firstKey()) - 1);
                            }
                        } else if (n == -1) {
                            if (map.get(map.lastKey()) == 1) {
                                map.remove(map.lastKey());
                            } else {
                                map.put(map.lastKey(), map.get(map.lastKey()) - 1);
                            }
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.firstKey()).append(" ").append(map.lastKey()).append("\n");
            }
            map.clear();

        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}