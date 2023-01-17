package baekjoon.silver.Num18258;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int value;
        int lastAdd = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push":
                    lastAdd = Integer.parseInt(st.nextToken());
                    queue.offer(lastAdd);
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        value = -1;
                    } else {
                        value = queue.poll();
                    }
                    bw.write(value + "\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        value = 1;
                    } else {
                        value = 0;
                    }
                    bw.write(value + "\n");
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        value = -1;
                    } else {
                        value = queue.peek();
                    }
                    bw.write(value + "\n");
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        value = -1;
                    } else {
                        value = lastAdd;
                    }
                    bw.write(value + "\n");
                    break;

            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
