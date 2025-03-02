package baekjoon.silver.Num05614;

import java.io.*;
import java.util.*;

public class Main {
    static class Product implements Comparable<Product> {
        String key;
        int value;

        public Product(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Product o) {
            if (this.key.length() == o.key.length()) {
                return this.key.compareTo(o.key);
            }
            return Integer.compare(this.key.length(), o.key.length());
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String key = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            map.put(key, map.getOrDefault(key, 0) + value);
        }

        List<Product> products = new ArrayList<>();
        for (String key : map.keySet()) {
            products.add(new Product(key, map.get(key)));
        }
        Collections.sort(products);

        for (Product product : products) {
            sb.append(product.key).append(" ").append(product.value).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}