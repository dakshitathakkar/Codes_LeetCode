class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
        return func(0,0,dp,nums1,nums2);
    }

    public int func(int i, int j, int[][] dp, int[] nums1, int[] nums2){
        if(i==nums1.length || j==nums2.length){
            return (int) -1e9;
        }

        if(dp[i][j] != Integer.MIN_VALUE){
            return dp[i][j];
        }

        int take = nums1[i]*nums2[j];
        int res = Math.max(Math.max(take, take + func(i+1,j+1,dp,nums1,nums2)), Math.max(func(i+1,j,dp,nums1,nums2),func(i,j+1,dp,nums1,nums2)));
        return dp[i][j] = res;
    }
}