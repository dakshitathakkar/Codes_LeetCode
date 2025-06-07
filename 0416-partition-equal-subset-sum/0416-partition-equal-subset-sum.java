class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum +=nums[i];
        }
        if(sum %2 != 0){
            return false;
        }
        sum /=2;
        boolean[][] dp = new boolean[n+1][sum+1];
        return func(n-1,nums,sum, dp);
    }

    public boolean func(int n, int[] nums, int sum, boolean[][] dp){
        if(sum == 0){
            return true;
        }
        if(n<0 || sum <0)   return false;
        if(dp[n][sum])  return true;

        return dp[n][sum] = func(n-1,nums,sum-nums[n],dp) || func(n-1,nums,sum,dp);
    }
}