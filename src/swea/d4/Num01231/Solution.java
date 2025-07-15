package swea.d4.Num01231;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static char[] tree;
    static StringBuilder sb;

    static void inOrder(int index) {
        if (index > N) {
            return;
        }

        inOrder(index * 2);
        sb.append(tree[index]);
        inOrder(index * 2 + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            N = Integer.parseInt(br.readLine());
            tree = new char[N + 1];
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                tree[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
            }
            inOrder(1);
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}