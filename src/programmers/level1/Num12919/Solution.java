package programmers.level1.Num12919;

import java.util.*;

class Solution {
    public String solution(String[] seoul) {
        StringBuilder sb = new StringBuilder();
        sb.append("김서방은 ").append(Arrays.asList(seoul).indexOf("Kim")).append("에 있다");
        return sb.toString();
    }
}