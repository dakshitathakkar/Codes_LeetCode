class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
       // List<Integer> tempList = new ArrayList<>();
        backtrack(result,nums,new ArrayList<>(),0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, int[] nums, List<Integer> tempList, int startIdx){
        result.add(new ArrayList<>(tempList));
        for(int i= startIdx; i<nums.length;i++){
            tempList.add(nums[i]);
            backtrack(result,nums,tempList,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}