class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapp = new HashMap<>();
        for (int i = 0; i<nums.length; i++){
            int num = nums[i];
            int diff = target - num;
            if (mapp.containsKey(diff)){
                return new int[] {mapp.get(diff),i};
            }
            mapp.put(num, i);
        }
        return new int[] {};
    }
}
