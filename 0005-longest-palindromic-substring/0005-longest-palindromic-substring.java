class Solution {
    static int[][] t = new int[1001][1001];
    public String longestPalindrome(String s) {
        //char[] str = s.toCharArray();
        int start = 0;
        int end = 0;
        int maxlen = 1;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        //for
        for(int i=0;i<n;i++){
            dp[i][i] = true;
            for(int j=0;j<i;j++){
                if(s.charAt(j)==s.charAt(i) && (i-j<=2 || dp [j+1][i-1])){
                    dp[j][i] = true;
                    if(i-j+1>maxlen){
                        maxlen = i-j+1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }

}