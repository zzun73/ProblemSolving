package programmers.level2.Num12911;

class Solution {
    public int solution(int n) {
        int cur = n + 1;
        int targetBin = Integer.bitCount(n);

        while (Integer.bitCount(cur) != targetBin) {
            cur++;
        }

        return cur;
    }
}