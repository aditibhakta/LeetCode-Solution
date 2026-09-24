class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int maxLen = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            sum = sum + nums[j];
            int len = (j - i) + 1;

            while (sum >= target) {
                maxLen = Math.min(len, maxLen);
                sum = sum - nums[i];
                i++;

                len = (j - i) + 1;
            }
        }
        if (maxLen == Integer.MAX_VALUE) {
            return 0;
        }
        return maxLen;
    }
}