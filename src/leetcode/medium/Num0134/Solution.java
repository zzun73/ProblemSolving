package leetcode.medium.Num0134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) {
            return -1;
        }

        int start = 0, path = 0;
        for (int i = 0; i < gas.length; i++) {
            path += gas[i] - cost[i];
            if (path < 0) {
                start = i + 1;
                path = 0;
            }
        }

        return start;
    }
}