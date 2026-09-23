class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int n1 = 0; n1 < nums.length - 2; n1++) {

            if (n1 > 0 && nums[n1] == nums[n1 - 1]) {
                continue;
            }

            int n2 = n1 + 1;
            int n3 = nums.length - 1;

            for (; n2 < n3; ) {

                if (nums[n2] + nums[n3] == -(nums[n1])) {

                    result.add(Arrays.asList(nums[n1], nums[n2], nums[n3]));

                    n2++;
                    n3--;

                    while (n2 < n3 && nums[n2] == nums[n2 - 1]) {
                        n2++;
                    }

                    while (n2 < n3 && nums[n3] == nums[n3 + 1]) {
                        n3--;
                    }

                } else if (nums[n2] + nums[n3] < -(nums[n1])) {
                    n2++;
                } else {
                    n3--;
                }
            }
        }

        return result;
    }
}