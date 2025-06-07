class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        long[][] dp = new long[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(0,n,1,nums,dp);
    }


    public long func(int idx, int n, int sign, int[] nums, long[][] dp){
        if(idx >= n){
            return 0;
        }
        if(dp[idx][sign < 0 ? 1 : 0] != -1){
            return dp[idx][sign < 0 ? 1 : 0];
        }
        long take = take = (nums[idx] * sign) + func(idx+1,n,-sign,nums,dp);
        long nottake = func(idx+1,n,sign,nums,dp);
        return dp[idx][sign < 0 ? 1 : 0] = Math.max(take,nottake);
    }
}