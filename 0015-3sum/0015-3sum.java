class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            int target = -nums[i];
            int j=i+1;
            int k = n-1;
            while(j<k){
                if(target == nums[j] + nums[k]){
                    List<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[j]);
                    arr.add(nums[k]);
                  
                    result.add(arr);
                   while(j<k && nums[j] == arr.get(1)) j++;
                    while(j<k && nums[k] == arr.get(2)) k--;
                }
                else if(target>nums[j] + nums[k]){
                    j++;
                }
                else{
                    k--;
                }
            }
            while(i+1 < n && nums[i+1]==nums[i]){
                i++;
            }
        }
        return result;
    }
}