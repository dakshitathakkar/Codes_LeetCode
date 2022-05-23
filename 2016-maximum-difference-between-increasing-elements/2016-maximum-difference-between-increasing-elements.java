class Solution {
    public int maximumDifference(int[] nums) {
        int max_Diff = -1;
        int min_ele = nums[0];
        for(int i=1; i<nums.length; i++){
            if((nums[i]-min_ele > max_Diff) && (nums[i]-min_ele !=0)){
                max_Diff = nums[i]-min_ele;
            }
            if(nums[i]<min_ele){
                min_ele = nums[i];
            }
        }
        return max_Diff;
    }
}