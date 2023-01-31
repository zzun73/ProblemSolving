package baekjoon.silver.Num01764;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            if (set.contains(line)) {
                answer.add(line);
            }
        }
        bw.write(answer.size() + "\n");

        Collections.sort(answer);
        Iterator<String> it = answer.iterator();
        while (it.hasNext()) {
            bw.write(it.next() + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
