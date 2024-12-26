package baekjoon.silver.Num30970;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class FirstProduct implements Comparable<FirstProduct> {
        int quality, price;

        public FirstProduct(int quality, int price) {
            this.quality = quality;
            this.price = price;
        }

        @Override
        public int compareTo(FirstProduct o) {
            if (this.quality == o.quality) {
                return this.price - o.price;
            }
            return o.quality - this.quality;
        }
    }

    static class SecondProduct implements Comparable<SecondProduct> {
        int quality, price;

        public SecondProduct(int quality, int price) {
            this.quality = quality;
            this.price = price;
        }

        @Override
        public int compareTo(SecondProduct o) {
            if (this.price == o.price) {
                return o.quality - this.quality;
            }
            return this.price - o.price;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<FirstProduct> first = new PriorityQueue<>();
        PriorityQueue<SecondProduct> second = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            first.add(new FirstProduct(a, b));
            second.add(new SecondProduct(a, b));
        }

        for (int i = 0; i < 2; i++) {
            FirstProduct firstProduct = first.poll();
            sb.append(firstProduct.quality).append(" ").append(firstProduct.price).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < 2; i++) {
            SecondProduct secondProduct = second.poll();
            sb.append(secondProduct.quality).append(" ").append(secondProduct.price).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}