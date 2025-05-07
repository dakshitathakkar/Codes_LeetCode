class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                int up = (int)(1e9);
                int left =(int)(1e9);
                if (i > 0) {
                    up = dp[i - 1][j];
                }
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = Math.min(up, left) + 1;

            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    continue;
                }
                int right = (int)(1e9);
                int down = (int)(1e9);
                if (i < m - 1) {
                    down = dp[i + 1][j];
                }
                if (j < n - 1) {
                    right = dp[i][j + 1];
                }
                dp[i][j] = Math.min(dp[i][j], Math.min(right, down) + 1);
            }

        }
        return dp;
    }
}