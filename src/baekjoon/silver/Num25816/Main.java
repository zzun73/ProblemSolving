package baekjoon.silver.Num25816;

import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        String name;
        double value;

        public Node(String name, double value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.value, o.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> valueMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            valueMap.put(key, valueMap.getOrDefault(key, 0) + i + 1);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }

        List<String> list = new ArrayList<>(valueMap.keySet());

        List<Node> nodes = new ArrayList<>();
        for (String s : list) {
            double values = valueMap.get(s) / (double) countMap.get(s);
            nodes.add(new Node(s, values));
        }
        Collections.sort(nodes);

        for (Node node : nodes) {
            sb.append(node.name).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}