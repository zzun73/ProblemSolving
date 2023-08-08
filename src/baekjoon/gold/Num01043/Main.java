package baekjoon.gold.Num01043;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] truth;
    static int[] root;

    public static void init() {
        for (int i = 1; i < root.length; i++) {
            root[i] = i;
        }
    }

    public static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if (ra == rb) return;

        if (ra > rb) {
            root[ra] = rb;
        } else {
            root[rb] = ra;
        }
    }

    public static int find(int x) {
        if (root[x] == x) {
            return x;
        }

        return root[x] = find(root[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int answer = 0;

        if (num != 0) {
            truth = new int[num];
            for (int i = 0; i < num; i++) {
                truth[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer>[] party = new ArrayList[M];
            root = new int[N + 1];
            init();
            for (int i = 0; i < M; i++) {
                party[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int size = Integer.parseInt(st.nextToken());
                for (int j = 0; j < size; j++) {
                    party[i].add(Integer.parseInt(st.nextToken()));
                }

                int temp = party[i].get(0);
                for (int j = 1; j < party[i].size(); j++) {
                    union(temp, party[i].get(j));
                }
            }
            for (int i = 0; i < M; i++) {
                boolean check = true;
                for (int t : truth) {
                    for (int people : party[i]) {
                        if (find(t) == find(people)) {
                            check = false;
                            break;
                        }
                    }
                    if (!check) {
                        break;
                    }
                }
                if (check) {
                    answer++;
                }
            }
        } else {
            answer = M;
        }
        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }
}