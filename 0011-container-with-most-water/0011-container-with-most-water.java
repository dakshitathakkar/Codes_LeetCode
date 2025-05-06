class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int max = Integer.MIN_VALUE;
        while(left < right){
            int curr = Math.min(height[left],height[right])*(right-left);
            max = Math.max(curr,max);
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}