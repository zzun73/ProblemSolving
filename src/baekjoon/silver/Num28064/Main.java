package baekjoon.silver.Num28064;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = 1; k <= Math.min(str[i].length(), str[j].length()); k++) {
                    if (str[i].endsWith(str[j].substring(0, k)) || str[j].endsWith(str[i].substring(0, k))) {
                        answer++;
                        break;
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}