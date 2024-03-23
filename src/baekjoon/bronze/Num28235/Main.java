package baekjoon.bronze.Num28235;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String output = "";
        switch (input) {
            case "SONGDO":
                output = "HIGHSCHOOL";
                break;
            case "CODE":
                output = "MASTER";
                break;
            case "2023":
                output = "0611";
                break;
            case "ALGORITHM":
                output = "CONTEST";
                break;
        }
        bw.write(output);
        br.close();
        bw.flush();
        bw.close();
    }
}
