package baekjoon.silver.Num11292;

import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {

    String name;
    double height;

    public Student(String name, double height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public int compareTo(Student s) {
        return Double.compare(s.height, this.height);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            Student[] students = new Student[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken();
                double height = Double.parseDouble(st.nextToken());
                students[i] = new Student(name, height);
            }
            Arrays.sort(students);
            double maxHeight = students[0].height;
            for (Student student : students) {
                if (student.height != maxHeight) {
                    break;
                }
                sb.append(student.name).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}