class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> num = new HashSet<>();
        for (int i=0; i< nums.length; i++){
            num.add(nums[i]);
        }
        int a = num.size();
        if (a <nums.length){
            return true;
        }
        else return false;
    }
}