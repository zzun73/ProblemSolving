package baekjoon.silver.Num15905;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
    int solve, penalty;

    public Person(int solve, int penalty) {
        this.solve = solve;
        this.penalty = penalty;
    }

    public int compareTo(Person o) {
        if (this.solve == o.solve) {
            return penalty - o.penalty;
        }
        return o.solve - solve;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Person[] person = new Person[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            person[i] = new Person(s, p);
        }
        Arrays.sort(person);

        int answer = 0;
        for (int i = 5; i < N; i++) {
            if (person[i].solve == person[4].solve) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}