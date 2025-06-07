class Solution {
    public int climbStairs(int n) {
        if(n==1 || n==0){
            return 1;
        }
        int[] t = new int[n+1];
        Arrays.fill(t,-1);
        t[0] = 1;
        t[1] = 1;
        return fibRec(t,n);
    }

    public int fibRec(int[] t, int n){
        if(t[n] != -1){
            return t[n];
        }
        t[n] = fibRec(t,n-1)+fibRec(t,n-2);
        return t[n];
    }
}