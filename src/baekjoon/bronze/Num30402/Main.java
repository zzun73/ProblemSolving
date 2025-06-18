package baekjoon.bronze.Num30402;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String answer = "";
        boolean found = false;

        for (int i = 0; i < 15 && !found; i++) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                continue;
            }

            for (char pixel : line.toCharArray()) {
                switch (pixel) {
                    case 'w':
                        answer = "chunbae";
                        found = true;
                        break;
                    case 'b':
                        answer = "nabi";
                        found = true;
                        break;
                    case 'g':
                        answer = "yeongcheol";
                        found = true;
                        break;
                }
                if (found) {
                    break;
                }
            }
        }

        bw.write(answer);

        bw.close();
        br.close();
    }
}
