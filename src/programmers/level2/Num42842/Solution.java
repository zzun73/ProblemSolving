package programmers.level2.Num42842;

class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;

        for (int height = 3; height <= sum / height; height++) {
            if (sum % height == 0) {
                int width = sum / height;

                if ((width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }
        return new int[0];
    }
}