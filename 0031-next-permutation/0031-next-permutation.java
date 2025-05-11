class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0){
            int j = n-1;
            while(i<j && nums[j]<=nums[i]) j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            Arrays.sort(nums,i+1,n);
        }
        else{
            Arrays.sort(nums);
        }



    }
}