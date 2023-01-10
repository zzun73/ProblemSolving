package baekjoon.bronze.Num25501;

import java.io.*;

public class Main {

    static int call;

    public static int helper(String str, int l, int r) {
        call++;
        if (l >= r) return 1;
        else if (str.charAt(l) != str.charAt(r)) return 0;
        else return helper(str, l + 1, r - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            call = 0;
            int returnValue = helper(str, 0, str.length()-1);
            bw.write(returnValue + " " + call + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
