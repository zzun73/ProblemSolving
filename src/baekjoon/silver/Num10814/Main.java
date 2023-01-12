package baekjoon.silver.Num10814;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static class Person {
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return this.age + " " + this.name + "\n";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Person[] person = new Person[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            person[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(person, Comparator.comparingInt(o -> o.age));
        for (int i = 0; i < N; i++) {
            bw.write(person[i].toString());
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
