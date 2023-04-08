package baekjoon.silver.Num07785;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        TreeSet<String> set = new TreeSet<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String commute = st.nextToken();
            if (commute.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }
        List<String> sortedList = new ArrayList<>(set);
        Collections.reverse(sortedList);

        for (String name : sortedList) {
            bw.write(name + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
