class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int j = 0;
        int i =0;
        int min = Integer.MAX_VALUE;

        while(j<n){
            sum = sum + nums[j];
          //  System.out.println(sum +" " + min);
            while(sum > target){
                min = Math.min(min,j-i+1);
                sum = sum - nums[i];
                i++;
            }

            if(sum == target){
                min = Math.min(min,j-i+1);
            }
            j++;
        }
        return min==Integer.MAX_VALUE?0:min;
    }
} 