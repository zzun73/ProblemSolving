package baekjoon.bronze.Num18698;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String steps = br.readLine();
            int stepCount = 0;
            for (int i = 0; i < steps.length(); i++) {
                if (steps.charAt(i) == 'D') {
                    break;
                }
                stepCount++;
            }
            sb.append(stepCount).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}