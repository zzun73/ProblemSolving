package programmers.level2.Num43165;

class Solution {
    static int answer;

    void helper(int index, int target, int[] numbers, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        helper(index + 1, target, numbers, sum + numbers[index]);
        helper(index + 1, target, numbers, sum - numbers[index]);
    }

    public int solution(int[] numbers, int target) {
        answer = 0;
        helper(0, target, numbers, 0);
        return answer;
    }
}