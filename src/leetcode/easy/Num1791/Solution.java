package leetcode.easy.Num1791;

class Solution {
    public int findCenter(int[][] edges) {
        int[] arr = new int[edges.length + 2];
        int index, max, result = 0;
        for (int i = 0; i < edges.length; i++) {
            index = edges[i][0];
            arr[index]++;
            index = edges[i][1];
            arr[index]++;
        }

        max = edges.length;
        for (int i = 1; i < arr.length; i++) {
            if (max == arr[i])
                result = i;
        }

        return result;
    }
}