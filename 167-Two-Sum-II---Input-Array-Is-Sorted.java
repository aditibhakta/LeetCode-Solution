class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0; 
        for(int right = numbers.length - 1; right > 0;){

            if(numbers[left] + numbers[right] == target){
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            }else if (numbers[left] + numbers[right] < target){
                left++;
            }else {
                right--;
            }
        }
        return ans;
    }
}