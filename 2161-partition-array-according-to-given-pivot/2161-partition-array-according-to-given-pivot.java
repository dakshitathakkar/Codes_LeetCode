class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i] != Integer.MAX_VALUE && nums[i]<pivot){
                result[j] = nums[i];
                nums[i] = Integer.MAX_VALUE;
                j++;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i] != Integer.MAX_VALUE && nums[i]==pivot){
                result[j] = nums[i];
                nums[i] = Integer.MAX_VALUE;
                j++;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i] != Integer.MAX_VALUE && nums[i]>pivot){
                result[j] = nums[i];
                nums[i] = Integer.MAX_VALUE;
                j++;
            }
        }

        return result;
    }
}