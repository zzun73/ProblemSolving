package leetcode.easy.Num0771;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        char[] s = stones.toCharArray();
        int answer = 0;

        for (int i = 0; i < s.length; i++) {
            if (jewels.indexOf(s[i]) > -1)
                answer++;
        }
        return answer;
    }
}