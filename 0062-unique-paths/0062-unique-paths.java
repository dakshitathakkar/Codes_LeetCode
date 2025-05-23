class Solution {
    public int uniquePaths(int m, int n) {
        //space optimized
        int[] prev = new int[n];
        for(int i=0;i<m;i++){
            int[] curr = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    curr[j] = 1;
                    continue;
                }
                if(j==0){
                    curr[j] = prev[j];
                    continue;
                }
                curr[j] = prev[j] + curr[j-1];
            }
            prev = curr;
        }
        return prev[n-1];

        //TABULATION
        // int[][] dp = new int[m][n];
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(i==0 && j==0){
        //             dp[i][j] = 1;
        //             continue;
        //         }
        //         int up = 0;
        //         int left = 0;
        //         if(i>0){
        //             up = dp[i-1][j];
        //         }
        //         if(j>0){
        //             left = dp[i][j-1];
        //         }
        //         dp[i][j] = up + left;
        //     }
        // }
        // return dp[m-1][n-1];
    }
    //MEMOIZATION
    // public int func(int i, int j,int[][] dp){
    //     if(i==0 && j==0){
    //         return 1;
    //     }
    //     if(i<0 || j<0){
    //         return 0;
    //     }
    //     if(dp[i][j] !=-1){
    //         return dp[i][j];
    //     }
    //     int up = func(i-1,j,dp);
    //     int left = func(i,j-1,dp);
    //     return dp[i][j] =up+left;
    // }
}