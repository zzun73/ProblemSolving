package baekjoon.silver.Num10828;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

//class MyStack {
//    int pt;
//    int[] myStack;
//
//    public MyStack(int size) {
//        super();
//        this.pt = 0;
//        this.myStack = new int[size + 1];
//    }
//
//    public void push(int val) {
//        myStack[pt++] = val;
//    }
//
//    public int pop() {
//        if (empty() == 1) {
//            return -1;
//        }
//        return myStack[--pt];
//    }
//
//    public int size() {
//        return pt;
//    }
//
//    public int empty() {
//        return pt == 0 ? 1 : 0;
//    }
//
//    public int top() {
//        if (empty() == 1) {
//            return -1;
//        }
//        return myStack[pt - 1];
//    }
//}
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//
//        StringBuilder sb = new StringBuilder();
//        int N = Integer.parseInt(br.readLine());
//        MyStack myStack = new MyStack(N + 1);
//
//        while (N-- > 0) {
//            st = new StringTokenizer(br.readLine(), " ");
//            String command = st.nextToken();
//
//            switch (command) {
//                case "push":
//                    myStack.push(Integer.parseInt(st.nextToken()));
//                    break;
//                case "pop":
//                    sb.append(myStack.pop()).append("\n");
//                    break;
//                case "size":
//                    sb.append(myStack.size()).append("\n");
//                    break;
//                case "empty":
//                    sb.append(myStack.empty()).append("\n");
//                    break;
//                case "top":
//                    sb.append(myStack.top()).append("\n");
//                    break;
//            }
//        }
//        bw.write(sb.toString());
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Stack<Integer> stack = new Stack<>();
        int X;
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push":
                    X = Integer.parseInt(st.nextToken());
                    stack.push(X);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        X = -1;
                    } else {
                        X = stack.pop();
                    }
                    bw.write(X + "\n");
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        X = 1;
                    } else {
                        X = 0;
                    }
                    bw.write(X + "\n");
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        X = -1;
                    } else {
                        X = stack.peek();
                    }
                    bw.write(X + "\n");
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
