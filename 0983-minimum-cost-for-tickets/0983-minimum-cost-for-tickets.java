class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[days[n-1]+1];
        boolean[] tracker = new boolean[dp.length];
        for(int day: days){
            tracker[day] = true;
        }

        for(int i=1;i<dp.length;i++){
            if(!tracker[i]){
                dp[i] = dp[i-1];
                continue;
            }

            dp[i] = Math.min(dp[i-1] + costs[0],
                Math.min(dp[Math.max(i-7,0)]+costs[1],
                dp[Math.max(i-30,0)] + costs[2]));
        }

        return dp[dp.length-1];
    }
}