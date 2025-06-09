class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)    
            Arrays.fill(dp[i],-1);
        return func(text1.toCharArray(), text2.toCharArray(),m-1,n-1,dp);
    }

    public int func(char[] text1, char[] text2, int m, int n, int[][] dp){
        if(m<0 || n <0)   return 0;
        if(dp[m][n] != -1)  return dp[m][n];
        if(text1[m] == text2[n]){
            return dp[m][n] = 1 + func(text1,text2, m-1,n-1,dp);
        }
        else
            return dp[m][n] = Math.max(func(text1,text2,m-1,n,dp), func(text1,text2,m,n-1,dp));
    }
}