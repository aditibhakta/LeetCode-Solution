class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 2;
        for(int r = 2; r < nums.length; r++){
            if(nums[r] != nums[count - 2]){
                nums[count] = nums[r];
                count++;
            }
        }
        return count;
    }
}