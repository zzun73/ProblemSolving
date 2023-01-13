package baekjoon.silver.Num16198;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> path;
    static int answer;

    public static void helper(int pathSum) {
        if (path.size() == 3) {
            pathSum += path.get(0) * path.get(path.size() - 1);
            answer = Math.max(answer, pathSum);
            return;
        }

        for (int i = 1; i < path.size() - 1; i++) {
            int selsectNum = path.get(i);
            int energy = (path.get(i - 1) * path.get(i + 1));
            path.remove(i);
            helper(pathSum + energy);
            path.add(i, selsectNum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        path = new ArrayList<>();
        answer = 0;
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(st.nextToken());
            path.add(X);
        }

        helper(0);
        System.out.println(answer);
        br.close();
    }
}
