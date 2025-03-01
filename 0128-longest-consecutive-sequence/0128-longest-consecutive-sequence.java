class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int result = 0;
        for(Integer num : set){
             if(!set.contains(num-1)){
                int count = 1;
                int number = num;
                while(set.contains(number+1)){
                    count++;
                    number++;
                }
                result = Math.max(result,count);
            }
        }

        return result;
    }
}