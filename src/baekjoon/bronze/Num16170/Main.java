package baekjoon.bronze.Num16170;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy\nMM\ndd");

        bw.write(formatter.format(localDate) + "");

        bw.flush();
        bw.close();
    }
}
