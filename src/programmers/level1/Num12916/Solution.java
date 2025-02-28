package programmers.level1.Num12916;

class Solution {
    boolean solution(String s) {
        int pCount = s.length() - s.replaceAll("p|P", "").length();
        int yCount = s.length() - s.replaceAll("y|Y", "").length();
        return pCount == yCount;
    }
}