package baekjoon.silver.Num01935;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static double calc(double num1, double num2, char operator) {
        if (operator == '+') return num1 + num2;
        if (operator == '-') return num1 - num2;
        if (operator == '*') return num1 * num2;
        if (operator == '/') return num1 / num2;

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        char alphabet = 'A';
        Map<Character, Double> map = new HashMap<>();
        while (N-- > 0) {
            map.put(alphabet, Double.parseDouble(br.readLine()));
            alphabet++;
        }

        Deque<Double> deque = new ArrayDeque<>();
        for (char ch : line.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                deque.addLast(map.get(ch));
            } else {
                double num2 = deque.pollLast();
                double num1 = deque.pollLast();
                deque.addLast(calc(num1, num2, ch));
            }
        }

        bw.write(String.format("%.2f", deque.poll()));

        br.close();
        bw.close();
    }
}