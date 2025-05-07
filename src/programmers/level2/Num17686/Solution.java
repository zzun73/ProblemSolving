package programmers.level2.Num17686;

import java.util.*;

class File implements Comparable<File> {
    String head;
    String number;
    String tail;

    public File(String head, String number, String tail) {
        this.head = head;
        this.number = number;
        this.tail = tail;
    }

    @Override
    public int compareTo(File target) {

        if (this.head.compareToIgnoreCase(target.head) == 0) {
            int originNumber = Integer.parseInt(this.number);
            int targetNumber = Integer.parseInt(target.number);
            if (originNumber == targetNumber) {
                return 0;
            }

            return originNumber - targetNumber;
        }

        return this.head.compareToIgnoreCase(target.head);
    }
}

class Solution {
    public String[] solution(String[] files) {
        File[] fileList = new File[files.length];

        // 분해
        for (int i = 0; i < files.length; i++) {
            String cur = files[i];
            String h, n, t;
            int hs = 0, he = 0, ns = 0, ne = 0, ts = 0;
            while (he < cur.length() &&
                    !(cur.charAt(he) >= '0' && cur.charAt(he) <= '9')) {
                he++;
            }
            if (he < cur.length()) {
                ns = he;
                ne = ns;
                while (ne < cur.length() && (cur.charAt(ne) >= '0' && cur.charAt(ne) <= '9')) {
                    ne++;
                }

                ts = ne;
            }

            h = cur.substring(hs, he);
            n = cur.substring(ns, ne);
            t = cur.substring(ts);

            fileList[i] = new File(h, n, t);
        }

        // 정렬
        Arrays.sort(fileList);

        // 변환
        String[] answer = new String[files.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(fileList[i].head).append(fileList[i].number).append(fileList[i].tail);
            answer[i] = sb.toString();
            sb.setLength(0);
        }

        return answer;
    }
}