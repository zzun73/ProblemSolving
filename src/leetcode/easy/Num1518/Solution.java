package leetcode.easy.Num1518;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int remain;
        int answer = numBottles;
        while (numBottles >= numExchange) {
            remain = numBottles % numExchange;
            numBottles /= numExchange;
            answer += numBottles;
            numBottles += remain;
        }
        return answer;
    }
}