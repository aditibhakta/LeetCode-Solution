class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(seen.containsKey(nums[i])){
                int prevIdx = seen.get(nums[i]);
                if(i - prevIdx <= k){
                    return true;
                }
            }
            seen.put(nums[i], i);
        }
        return false;
    }
}