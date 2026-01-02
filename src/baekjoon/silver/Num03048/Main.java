package baekjoon.silver.Num03048;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dir;
    static char[] line;

    static void swap(int a, int b) {
        char tempWord = line[a];
        line[a] = line[b];
        line[b] = tempWord;

        int tempDir = dir[a];
        dir[a] = dir[b];
        dir[b] = tempDir;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());

        dir = new int[N1 + N2];
        line = new char[N1 + N2];

        char[] ch = br.readLine().toCharArray();
        for (int i = 0; i < N1; i++) {
            line[i] = ch[N1 - i - 1];
            dir[i] = 1;
        }

        ch = br.readLine().toCharArray();
        for (int i = 0; i < N2; i++) {
            line[N1 + i] = ch[i];
            dir[N1 + i] = 2;
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            for (int i = 0; i < N1 + N2 - 1; ) {
                if (dir[i] == 1 && dir[i + 1] == 2) {
                    swap(i, i + 1);
                    i += 2;
                } else {
                    i++;
                }
            }
        }

        for (char c : line) {
            sb.append(c);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}