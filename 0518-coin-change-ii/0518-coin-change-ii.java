class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][5001];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(coins,0,n,amount,dp);
    }
    public int func(int[] coins, int i, int n, int amount,int[][] dp){
        if(i>=n || amount <=0){
            return amount==0 ? 1:0;   
        }

        if(dp[i][amount] != -1)   return dp[i][amount];

        if(coins[i] > amount){
            return dp[i][amount] = func(coins,i+1,n,amount,dp);
        }

        int take = func(coins,i,n,amount - coins[i],dp);
        int nottake = func(coins,i+1,n,amount,dp);
        return dp[i][amount] = take+nottake;
    }

}