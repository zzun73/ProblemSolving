package baekjoon.bronze.Num06825;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double weight = Double.parseDouble(br.readLine());
        double height = Double.parseDouble(br.readLine());

        double bmi = weight / (height * height);
        String answer = "Normal weight";

        if (bmi >= 25) {
            answer = "Overweight";
        } else if (bmi < 18.5) {
            answer = "Underweight";
        }
        bw.write(answer);

        br.close();
        bw.flush();
        bw.close();
    }
}
