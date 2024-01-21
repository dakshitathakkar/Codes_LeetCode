class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n==2){
            Math.max(nums[0], nums[1]);
        }
        int[] t = new int[n];
        Arrays.fill(t,-1);

        return maxProf(t,nums,n-1);
    }

    public int maxProf(int[] t, int[] nums, int n){
        if (n < 0) {
        return 0;
    }
        if(t[n] != -1){
            return t[n];
        }

        t[n] = Math.max(nums[n] + maxProf(t,nums,n-2), maxProf(t,nums,n-1));
        System.out.println(n + " " + t[n]);
        return t[n];
    }

}