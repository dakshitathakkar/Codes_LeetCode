class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        // dp[0] = cost[0];
        // dp[1] = cost[1];
        return func(n,dp,cost);
    }

    public int func(int n, int[] dp, int[] cost){
        if(n<=0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        int left = cost[n-1] + func(n-1,dp,cost);
        int right = 0;
        if(n>1) right = cost[n-2] + func(n-2,dp,cost);
        dp[n] = Math.min(left,right);
        return dp[n];
    }
}