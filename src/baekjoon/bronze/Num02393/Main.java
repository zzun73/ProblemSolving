package baekjoon.bronze.Num02393;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append("  ___  ___  ___\n")
          .append("  | |__| |__| |\n")
          .append("  |           |\n")
          .append("   \\_________/\n")
          .append("    \\_______/\n")
          .append("     |     |\n")
          .append("     |     |\n")
          .append("     |     |\n")
          .append("     |     |\n")
          .append("     |_____|\n")
          .append("  __/       \\__\n")
          .append(" /             \\\n")
          .append("/_______________\\");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}