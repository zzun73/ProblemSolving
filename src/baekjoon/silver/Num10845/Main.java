package baekjoon.silver.Num10845;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//class Node {
//    int value;
//    Node next;
//
//    public Node(int value) {
//        this.value = value;
//        next = null;
//    }
//}
//
//class MyQueue {
//
//    Node front, rear;
//    int size;
//
//    public MyQueue() {
//        front = rear = null;
//        size = 0;
//    }
//
//    public boolean empty() {
//        return front == null && rear == null;
//    }
//
//    public void push(int X) {
//        Node node = new Node(X);
//        if (empty()) {
//            front = rear = node;
//        } else {
//            rear.next = node;
//            rear = node;
//        }
//        size++;
//    }
//
//    public int pop() {
//        if (empty()) {
//            return -1;
//        }
//        size--;
//        int popValue = front.value;
//        front = front.next;
//        if (front == null) {
//            rear = null;
//        }
//        return popValue;
//    }
//
//    public int front() {
//        if (empty()) {
//            return -1;
//        }
//        return front.value;
//    }
//
//    public int back() {
//        if (empty()) {
//            return -1;
//        }
//        return rear.value;
//    }
//
//    public int size() {
//        return this.size;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//
//        StringBuilder sb = new StringBuilder();
//        int N = Integer.parseInt(br.readLine());
//        MyQueue myQueue = new MyQueue();
//        while (N-- > 0) {
//            st = new StringTokenizer(br.readLine(), " ");
//            String command = st.nextToken();
//
//            switch (command) {
//                case "push":
//                    myQueue.push(Integer.parseInt(st.nextToken()));
//                    break;
//                case "pop":
//                    sb.append(myQueue.pop()).append("\n");
//                    break;
//                case "size":
//                    sb.append(myQueue.size()).append("\n");
//                    break;
//                case "empty":
//                    sb.append(myQueue.empty() ? 1 : 0).append("\n");
//                    break;
//                case "front":
//                    sb.append(myQueue.front()).append("\n");
//                    break;
//                case "back":
//                    sb.append(myQueue.back()).append("\n");
//                    break;
//            }
//        }
//        bw.write(sb.toString());
//
//        br.close();
//        bw.flush();
//        bw.close();
//
//    }
//}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Queue<Integer> queue = new LinkedList<>();
        int value;
        int lastAdd = 0;
        int N = Integer.parseInt(br.readLine());

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
