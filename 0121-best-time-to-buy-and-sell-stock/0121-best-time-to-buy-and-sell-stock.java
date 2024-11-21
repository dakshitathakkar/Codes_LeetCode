class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] minLeft = new int[n];
        int[] maxRight = new int[n];
        minLeft[0] = prices[0];
        maxRight[n-1] = prices[n-1];
        int result = 0;
        int j = n-2;

        for(int i=1;i<n;i++){
            minLeft[i] = Math.min(prices[i],minLeft[i-1]);
            maxRight[j] = Math.max(prices[j],maxRight[j+1]);
            j--;
        }

        for(int i=0;i<n;i++){
            result = Math.max(result,maxRight[i] - minLeft[i]);
        }

        return result;
    }
}