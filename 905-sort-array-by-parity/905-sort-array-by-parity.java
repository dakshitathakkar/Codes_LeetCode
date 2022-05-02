class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length == 0)
            return nums;
        int e = nums[0];
        int o = nums[0];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] %2 == 0)
                res.add(0,nums[i]);
            else
                res.add(nums[i]);
        }
        int[] arr = res.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}