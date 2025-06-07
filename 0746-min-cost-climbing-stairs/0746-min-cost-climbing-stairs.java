class Solution {
    public int minCostClimbingStairs(int[] cost) {  
	int n = cost.length;
    int[] dp = new int[n+1];
    Arrays.fill(dp,-1);
	return func(n,cost,dp);
}


int func(int idx, int[] cost, int[] dp){
	//base case	
	if(idx<=0){
		return 0;
	}
    if(dp[idx] !=-1){
        return dp[idx];
    }
	int left = cost[idx-1]+func(idx-1,cost,dp);
	int right=0;
	if(idx>1)
		right = cost[idx-2]+func(idx-2,cost,dp);
	return dp[idx]=Math.min(left,right);
}

}