package leetcode.easy.Num0824;

class Solution {
    public String toGoatLatin(String sentence) {
        String[] str = sentence.split(" ");
        String mo = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder();
        StringBuilder post = new StringBuilder();

        for (String word : str) {
            String pre = String.valueOf(word.charAt(0));
            if (mo.contains(pre)) {
                sb.append(word);
            } else {
                sb.append(word.substring(1)).append(pre);
            }
            post.append("a");
            sb.append("ma").append(post).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}