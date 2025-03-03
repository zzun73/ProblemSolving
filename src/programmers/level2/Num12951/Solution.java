package programmers.level2.Num12951;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split("");

        for (int i = 0; i < str.length; i++) {
            String cur = str[i];

            if (!cur.isEmpty()) {
                sb.append(Character.toUpperCase(cur.charAt(0)));
                sb.append(cur.substring(1).toLowerCase());
            }
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);

        return sb.toString();
    }
}