package leetcode.easy.Num0383;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            if (count[ch - 'a']-- < 1) {
                return false;
            }
        }
        return true;
    }
}