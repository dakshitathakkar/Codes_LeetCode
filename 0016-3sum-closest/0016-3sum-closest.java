class Solution {
    public int threeSumClosest(int[] nums, int t) {
        int n = nums.length;
        Arrays.sort(nums);
        
       
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int j=i+1;
            int k = n-1;
            while(j<k){
                int target = nums[i] + nums[j] + nums[k];
                if(Math.abs(target-t) < Math.abs(diff-t)){
                    //System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                    diff = target;
                }
                if(target>t){
                    k--;
                }
                else if(target<t){
                    j++;
                }
                else{
                    return target;
                }
            }
            while(i+1 < n && nums[i+1]==nums[i]){
                i++;
            }
        }
        return diff;        
    }
}