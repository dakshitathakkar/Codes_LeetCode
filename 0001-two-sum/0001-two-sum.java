class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> idxMap = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            int rem = target - nums[i];
            if(idxMap.containsKey(rem)){
                result[0] = i;
                result[1] = idxMap.get(rem);
                break;
            }
            idxMap.put(nums[i],i);
        }

        return result;
    }
}