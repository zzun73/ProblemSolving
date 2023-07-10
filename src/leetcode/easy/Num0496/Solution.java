package leetcode.easy.Num0496;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int cur = nums1[i];
            int next = -1;

            int j = 0;
            while (nums2[j] != cur) {
                j++;
            }

            for (int k = j + 1; k < nums2.length; k++) {
                if (nums2[k] > cur) {
                    next = nums2[k];
                    break;
                }
            }

            answer[i] = next;
        }

        return answer;
    }
}
