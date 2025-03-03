class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int l=0;
        int r=n-1;
        Arrays.fill(result,pivot);
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
                result[l] = nums[i];
                l++;
            }
            if(nums[n-i-1]>pivot){
                result[r] = nums[n-i-1];
                r--;
            }
        }
        return result;
    }
}