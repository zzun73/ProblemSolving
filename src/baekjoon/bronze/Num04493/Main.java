package baekjoon.bronze.Num04493;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int firstPlayerPoint = 0;
            int secondPlayerPoint = 0;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");

                String firstPlayer = st.nextToken();
                String secondPlayer = st.nextToken();

                if (firstPlayer.equals("R") && secondPlayer.equals("S")
                        || firstPlayer.equals("S") && secondPlayer.equals("P")
                        || firstPlayer.equals("P") && secondPlayer.equals("R")) {
                    firstPlayerPoint++;

                } else if (secondPlayer.equals("R") && firstPlayer.equals("S")
                        || secondPlayer.equals("S") && firstPlayer.equals("P")
                        || secondPlayer.equals("P") && firstPlayer.equals("R")) {
                    secondPlayerPoint++;
                }


            }
            if (firstPlayerPoint > secondPlayerPoint) {
                sb.append("Player 1");
            } else if (firstPlayerPoint < secondPlayerPoint) {
                sb.append("Player 2");
            } else {
                sb.append("TIE");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}