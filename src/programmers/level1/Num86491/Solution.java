package programmers.level1.Num86491;

class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;

        for (int[] size : sizes) {
            int W = Math.max(size[0], size[1]);
            int H = Math.min(size[0], size[1]);

            maxW = Math.max(maxW, W);
            maxH = Math.max(maxH, H);
        }

        return maxW * maxH;
    }
}