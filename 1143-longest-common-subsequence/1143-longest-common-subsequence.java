class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        // for(int i=0; i<=m;i++){
        //     dp[i][0] = 0;
        // }
        // for(int j=0; j<=n; j++){
        //     dp[0][j] = 0;
        // }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1;j<dp[i].length;j++){
                if(str1[i-1] == str2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}