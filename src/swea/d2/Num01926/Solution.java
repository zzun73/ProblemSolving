package swea.d2.Num01926;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String cur = String.valueOf(i);
            String str = cur.replaceAll("[369]", "");
            if (cur.length() == str.length()) {
                sb.append(cur).append(" ");
            } else {
                for (int j = 0; j < cur.length() - str.length(); j++) {
                    sb.append("-");
                }
                sb.append(" ");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
//package swea.d2.Num01926;
//
//import java.io.*;
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//
//        int N = Integer.parseInt(br.readLine());
//        for (int i = 1; i <= N; i++) {
//            String cur = String.valueOf(i);
//            String str = cur.replaceAll("3", "").replaceAll("6", "").replaceAll("9", "");
//            if (cur.length() == str.length()) {
//                sb.append(cur).append(" ");
//            } else {
//                for (int j = 0; j < cur.length() - str.length(); j++) {
//                    sb.append("-");
//                }
//                sb.append(" ");
//            }
//        }
//
//        bw.write(sb.toString());
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//}