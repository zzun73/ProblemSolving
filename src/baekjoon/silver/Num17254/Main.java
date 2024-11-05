package baekjoon.silver.Num17254;

import java.io.*;
import java.util.*;

class Word implements Comparable<Word> {
    int a, b;
    String c;

    public Word(int a, int b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Word w) {
        if (this.b == w.b) {
            return this.a - w.a;
        }
        return this.b - w.b;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Word> list = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            list.add(new Word(a, b, c));
        }
        Collections.sort(list);

        for (Word word : list) {
            sb.append(word.c);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}