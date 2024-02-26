package baekjoon.silver.Num17952;

import java.io.*;
import java.util.*;

class Task {
    int A, T;

    public Task(int a, int t) {
        A = a;
        T = t;
    }
}

public class Main {
    static int N, command, A, T, answer;
    static ArrayDeque<Task> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        deque = new ArrayDeque<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                A = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken()) - 1;

                if (T == 0) {
                    answer += A;
                } else {
                    deque.addFirst(new Task(A, T));
                }

            } else if (command == 0) {
                if (!deque.isEmpty()) {
                    Task cur = deque.pollFirst();
                    if (--cur.T == 0) {
                        answer += cur.A;
                    } else {
                        deque.addFirst(cur);
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
