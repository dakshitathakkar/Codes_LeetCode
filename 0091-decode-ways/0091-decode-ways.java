class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return func(0,n,s,dp);
    }

    public int func(int idx, int n, String s, int[] dp){
        if(idx == n){
            return 1;
        }
        if(s.charAt(idx) == '0')  return 0;
        if(dp[idx]!=-1) return dp[idx];

        int count = func(idx+1,n,s,dp);
        if(idx<n-1 && ((s.charAt(idx)-'0') * 10 + (s.charAt(idx+1) - '0')) < 27)
        count += func(idx+2,n,s,dp);
        return dp[idx] = count;
    }
}