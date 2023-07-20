package baekjoon.silver.Num05397;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String input = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> liter = list.listIterator();
            for (char ch : input.toCharArray()) {

                switch (ch) {
                    case '<':
                        if (liter.hasPrevious()) {
                            liter.previous();
                        }
                        break;

                    case '>':
                        if (liter.hasNext()) {
                            liter.next();
                        }
                        break;

                    case '-':
                        if (liter.hasPrevious()) {
                            liter.previous();
                            liter.remove();
                        }
                        break;
                    default:
                        liter.add(ch);
                }
            }
            for (char c : list) {
                sb.append(c);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
