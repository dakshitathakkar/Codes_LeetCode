class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(hashSet.contains(nums[i])){
                return nums[i];
            }
            hashSet.add(nums[i]);
        }

        return -1;
    }
}