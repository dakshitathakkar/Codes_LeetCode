class Solution {
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        return func(n,dp);
    }

    public int func(int n, int[] dp){
        if(dp[n] !=-1){
            return dp[n];
        }

        return dp[n] = func(n-1,dp) + func(n-2,dp);
    }
}