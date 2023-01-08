package baekjoon.silver.Num19949;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] solution;
    static List<Integer> path;
    static int answer, length;

    public static void helper(int depth) {
        if (depth == length) {
            int count = 0;
            for (int i = 0; i < length; i++) {
                if (path.get(i) == solution[i]) {
                    ++count;
                }
                if (count >= 5) {
                    answer++;
                    break;
                }
            }
            return;
        }

        for (int i = 1; i < 6; i++) {
            int size = path.size();
            if (size > 1 && (path.get(size - 1) == path.get(size - 2)) && path.get(size - 1) == i) {
                continue;
            }
            path.add(i);
            helper(depth + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        length = 10;

        solution = new int[length];
        path = new ArrayList<>();
        answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < length; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        helper(0);
        System.out.println(answer);

        br.close();
    }
}
