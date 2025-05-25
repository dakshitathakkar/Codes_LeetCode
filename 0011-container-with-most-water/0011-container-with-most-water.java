class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int max = Integer.MIN_VALUE;
        while(left<right){
            int val = 0;
            if(height[left]<height[right]){
                val = height[left] * (right-left);
                left++;
            }
            else if(height[left]>height[right]){
                val = height[right] * (right-left);
                right--;
            }
            else{
            val = height[left] * (right-left);
            left++;
            right--;
            }
            max = Math.max(max,val);
        }
        return max;
    }
}