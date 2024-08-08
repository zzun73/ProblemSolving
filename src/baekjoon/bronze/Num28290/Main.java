package baekjoon.bronze.Num28290;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        if (str.equals("fdsajkl;") || str.equals("jkl;fdsa")) {
            bw.write("in-out");
        } else if (str.equals("asdf;lkj") || str.equals(";lkjasdf")) {
            bw.write("out-in");
        } else if (str.equals("asdfjkl;")) {
            bw.write("stairs");
        } else if (str.equals(";lkjfdsa")) {
            bw.write("reverse");
        } else {
            bw.write("molu");
        }

        br.close();
        bw.close();
    }
}