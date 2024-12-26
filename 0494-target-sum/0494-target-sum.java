class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if((sum+target)%2!=0 || sum<target){
            return 0;
        }
        int sum1 = (target+sum)/2;
        //sum1 = Math.abs(sum1);
        if(sum1<0){
            return 0;
        }
        System.out.println(sum1);
        return countSubsetSum(nums,n,sum1);
    }

    public int countSubsetSum(int[] nums, int n, int sum){
        int[][] t = new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    t[i][j] = 0;
                }
                if(j==0){
                    t[i][j] = 1;
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(nums[i-1]<=j){
                    t[i][j] = t[i-1][j-nums[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}