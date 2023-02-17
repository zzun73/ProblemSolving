package baekjoon.silver.Num01620;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String number = String.valueOf(i);
            String pokemon = br.readLine();
            hashMap.put(number, pokemon);
            hashMap.put(pokemon, number);
        }

        for (int i = 1; i <= M; i++) {
            String question = br.readLine();
            bw.write(hashMap.get(question) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
