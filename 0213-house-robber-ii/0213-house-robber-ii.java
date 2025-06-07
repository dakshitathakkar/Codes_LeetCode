class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] t1 = new int[n+1];
        int[] t2 = new int[n+1];

        Arrays.fill(t1,-1);
        Arrays.fill(t2,-1);
        return Math.max(maxProf(t1,nums,n-1,0),maxProf(t2,nums,n,1));
    }

    public int maxProf(int[] t, int[] nums, int n, int idx){
        if (idx >= n) {
        return 0;
    }
        if(t[idx] != -1){
            return t[idx];
        }

        t[idx] = Math.max(nums[idx] + maxProf(t,nums,n,idx+2), maxProf(t,nums,n,idx+1));

        return t[idx];
    }
}