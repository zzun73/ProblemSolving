package leetcode.easy.Num0804;

import java.util.HashSet;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mos = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            sb.setLength(0);
            for (int j = 0; j < word.length(); j++) {
                sb.append(mos[word.charAt(j) - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}