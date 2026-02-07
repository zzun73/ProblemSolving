package baekjoon.silver.Num08979;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class Country {
        int id;
        int gold, silver, bronze;

        public Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    static boolean isBetter(Country a, Country b) {
        if (a.gold != b.gold) {
            return a.gold > b.gold;
        }
        if (a.silver != b.silver) {
            return a.silver > b.silver;
        }
        return a.bronze > b.bronze;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Country[] countries = new Country[N];
        Country target = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int key = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            countries[i] = new Country(key, g, s, b);
            if (key == K) {
                target = countries[i];
            }
        }

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (isBetter(countries[i], target)) {
                rank++;
            }
        }
        bw.write(String.valueOf(rank));

        br.close();
        bw.close();
    }
}