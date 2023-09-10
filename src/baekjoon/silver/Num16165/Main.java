package baekjoon.silver.Num16165;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String[]> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String team = br.readLine();
            int num = Integer.parseInt(br.readLine());
            String[] member = new String[num];
            for (int j = 0; j < num; j++) {
                member[j] = br.readLine();
            }
            Arrays.sort(member);
            map.put(team, member);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            switch (br.readLine()) {
                case "0":
                    for (String member : map.get(str)) {
                        sb.append(member).append("\n");
                    }
                    break;

                case "1":
                    for (String team : map.keySet()) {
                        for (String s : map.get(team)) {
                            if (s.equals(str)) {
                                sb.append(team).append("\n");
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
