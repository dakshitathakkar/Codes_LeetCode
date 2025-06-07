class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] t = new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(i==0){
                    t[i][j] = Integer.MAX_VALUE - 1;
                    //t[i][j]=-1;
                }
                if(j==0){
                    t[i][j] = 0;
                }
                // if(i==1 && j>0){
                //     if(j%coins[0] == 0){
                //         t[i][j] = j/coins[0];
                //     }
                //     else{
                //         t[i][j] = -1;
                //     }
                // }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1] <=j){
                    t[i][j] = Math.min(t[i][j-coins[i-1]] + 1, t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        System.out.println(Integer.MAX_VALUE);
        return t[n][amount]>=Integer.MAX_VALUE-1?-1:t[n][amount];
    }
}