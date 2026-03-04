package baekjoon.silver.Num23246;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Person implements Comparable<Person> {
        int number, multiply, plus;

        public Person(int number, int a, int b, int c) {
            this.number = number;
            this.multiply = a * b * c;
            this.plus = a + b + c;
        }

        @Override
        public int compareTo(Person o) {
            if (this.multiply == o.multiply) {
                if (this.plus == o.plus) {
                    return this.number - o.number;
                }
                return this.plus - o.plus;
            }
            return this.multiply - o.multiply;
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
            int number = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            person[i] = new Person(number, A, B, C);
        }
        Arrays.sort(person);

        for (int i = 0; i < 3; i++) {
            sb.append(person[i].number).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}