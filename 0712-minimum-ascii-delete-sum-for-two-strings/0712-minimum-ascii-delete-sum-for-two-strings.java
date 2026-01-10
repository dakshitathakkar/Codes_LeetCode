class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return func(dp, 0, 0, s1, s2);
    }

    public int func(int[][] dp, int i, int j, String s1, String s2) {
        int sum = 0;
        if (i == s1.length() || j == s2.length()) {
            if (i == s1.length() && j == s2.length())
                return 0;
            else if (i == s1.length()) {
                while (j < s2.length()) {
                    sum += Integer.valueOf(s2.charAt(j));
                    j++;
                }
            } else {
                while (i < s1.length()) {
                    sum += Integer.valueOf(s1.charAt(i));
                    i++;
                }
            }
            return sum;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            sum = func(dp, i + 1, j + 1, s1, s2);
        } else {
            sum = Math.min(Integer.valueOf(s1.charAt(i)) + func(dp, i + 1, j, s1, s2),
                    Integer.valueOf(s2.charAt(j)) + func(dp, i, j + 1, s1, s2));
        }
        return dp[i][j] = sum;

    }

}