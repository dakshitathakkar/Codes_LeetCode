class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prev = new int[n];
        int[] next = new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                prev[i] = 1;
                continue;
            }
            prev[i] = prev[i-1] * nums[i-1];
        }

        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                next[i] = 1;
                continue;
            }
            next[i] = next[i+1] * nums[i+1];
        }

        for(int i=0;i<n;i++){
            result[i] = prev[i]* next[i];
        }
        return result;
    }
}