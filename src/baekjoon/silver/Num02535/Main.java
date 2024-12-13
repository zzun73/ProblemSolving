package baekjoon.silver.Num02535;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Person implements Comparable<Person> {
        int nation, student, grade;

        public Person(int nation, int student, int grade) {
            this.nation = nation;
            this.student = student;
            this.grade = grade;
        }

        @Override
        public int compareTo(Person o) {
            return o.grade - this.grade;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Person[] person = new Person[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int nation = Integer.parseInt(st.nextToken());
            int student = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            person[i] = new Person(nation, student, grade);
        }

        Arrays.sort(person);
        int bronze = 2;

        if (person[0].nation == person[1].nation) {
            while (person[bronze].nation == person[0].nation) {
                bronze++;
            }
        }

        sb.append(person[0].nation).append(" ").append(person[0].student).append("\n");
        sb.append(person[1].nation).append(" ").append(person[1].student).append("\n");
        sb.append(person[bronze].nation).append(" ").append(person[bronze].student);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}