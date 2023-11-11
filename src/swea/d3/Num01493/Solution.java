package swea.d3.Num01493;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        HashMap<Integer, int[]> map = new HashMap<>();
        int val = 1;
        for (int i = 1; i < 290; i++) {
            int j = 1;
            for (int k = i; j < 290 && k > 0; k--, j++) {
                map.put(val++, new int[]{j, k});
            }
        }

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int[] posP = map.get(p);
            int[] posQ = map.get(q);
            int[] posSum = new int[2];
            int answer = 0;

            for (int i = 0; i < posP.length; i++) {
                posSum[i] = posP[i] + posQ[i];
            }
            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                int[] cur = entry.getValue();

                if (cur[0] == posSum[0] && cur[1] == posSum[1]) {
                    answer = entry.getKey();
                    break;
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}