package programmers.level2.Num12941;

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        for (int i = 0; i < B.length; i++) {
            answer += A[i] * B[B.length - i - 1];
        }
        return answer;
    }
}