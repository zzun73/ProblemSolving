package swea.d2.Num01940;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int curDistance = 0, curSpeed = 0;
            int speed;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());
                switch (X) {
                    case 0:
                        curDistance += curSpeed;
                        break;
                    case 1:
                        speed = Integer.parseInt(st.nextToken());
                        curSpeed += speed;
                        curDistance += curSpeed;
                        break;
                    case 2:
                        speed = Integer.parseInt(st.nextToken());
                        curSpeed -= speed;
                        if (curSpeed < 0) {
                            curSpeed = 0;
                        }
                        curDistance += curSpeed;
                        break;
                }
            }
            sb.append("#").append(t).append(" ").append(curDistance).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}