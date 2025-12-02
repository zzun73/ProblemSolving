package baekjoon.bronze.Num05342;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Double> price = new HashMap<>();
        price.put("Paper", 57.99);
        price.put("Printer", 120.50);
        price.put("Planners", 31.25);
        price.put("Binders", 22.50);
        price.put("Calendar", 10.95);
        price.put("Notebooks", 11.20);
        price.put("Ink", 66.95);

        double sum = 0.0;
        while (true) {
            String item = br.readLine();
            if (item.equals("EOI")) {
                break;
            }

            if (price.containsKey(item)) {
                sum += price.get(item);
            }
        }

        bw.write(String.format("$%.2f", sum));

        br.close();
        bw.close();
    }
}