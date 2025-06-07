class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum = sum+ nums[i];
        }
        if(sum%2 !=0){
            return false;
        }

        return subsetSum(nums,sum/2,n);
    }

    public boolean subsetSum(int[] nums, int sum, int n){
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int num : nums){
            for(int i=sum;i>=num;i--){
                dp[i] = dp [i] || dp[i-num];
            }
        }
        return dp[sum];
    }
}