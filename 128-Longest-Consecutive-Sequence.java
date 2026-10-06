class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!(set.contains(num - 1))) {
                int currLong = 1;
                int currNum = num;
                
                while(set.contains(currNum + 1)){
                    currLong++;
                    currNum++;
                }
                longest = Math.max(longest, currLong);
            }
        }
        return longest;
    }
}