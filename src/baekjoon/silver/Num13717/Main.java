package baekjoon.silver.Num13717;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int maxUpgrade = 0;
        String pokemonName = null;
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            st = new StringTokenizer(br.readLine(), " ");
            int upgradeCandy = Integer.parseInt(st.nextToken());
            int myCandy = Integer.parseInt(st.nextToken());

            int curUpgrade = 0;
            while (myCandy >= upgradeCandy) {
                curUpgrade++;
                myCandy -= upgradeCandy;
                myCandy += 2;
            }
            if (curUpgrade > 0) {
                count += curUpgrade;
            }
            if (curUpgrade > maxUpgrade) {
                maxUpgrade = curUpgrade;
                pokemonName = name;
            }
        }

        sb.append(count).append("\n").append(pokemonName);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}