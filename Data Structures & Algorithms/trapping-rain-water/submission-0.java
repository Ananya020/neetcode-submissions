class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        int n = height.length;
        int res = 0;
        for (int i = 0; i<n ; i++){
            int leftM = height[i];
            int rightM = height[i];
            for (int j =0; j<i; j++){
                leftM = Math.max(leftM, height[j]);
            }
            for (int j = i+1;j<n;j++){
                rightM = Math.max(rightM, height[j]);
            }
            res += Math.min(leftM, rightM) - height[i];
        }
        return res;
    }
}
