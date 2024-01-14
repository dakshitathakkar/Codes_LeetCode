class Solution {
    public int climbStairs(int n) {
        int count = 1;
        int currIdx = 1;
        int prev = 1;
        
        for(int i=2;i<=n;i++){
            count = currIdx+prev;
            prev = currIdx;
            currIdx = count;
        }
        return count;
    }
}