package leetcode.easy.Num2103;

class Solution {
    public int countPoints(String rings) {
        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            String r = "R" + i;
            String g = "G" + i;
            String b = "B" + i;

            if (rings.contains(r) && rings.contains(g) && rings.contains(b)) {
                answer++;
            }
        }
        return answer;
    }
}
