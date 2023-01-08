package baekjoon.bronze.Num02920;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[8];
        String answer = "";

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] - 1) {
                answer = "ascending";
            } else if (arr[i] == arr[i + 1] + 1) {
                answer = "descending";
            } else {
                answer = "mixed";
                break;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
