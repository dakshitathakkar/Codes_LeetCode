class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]  = 0;
        // dp[1] = nums[0];
        return func(n,dp,nums);
    }

    public int func(int n, int[] dp, int[] nums){
        if(n <=0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        int take = nums[n-1] + func(n-2,dp,nums);
        int nottake = func(n-1,dp,nums);
        return dp[n] = Math.max(take,nottake);
    }
}