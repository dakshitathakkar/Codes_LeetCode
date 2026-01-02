class Solution {
    public int repeatedNTimes(int[] nums) {
        int len = nums.length;
        int n = len/2;
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<len;i++){
            hmap.put(nums[i],hmap.getOrDefault(nums[i],0)+1);
            if(hmap.get(nums[i])==n){
                return nums[i];
            }
        }
        return nums[0];
    }
}