class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        func(result,candidates,target, new ArrayList<>());
        return result;
    }

    public void func(List<List<Integer>> result, int[] candidates, int target, List<Integer> tempList){
        //System.out.println(tempList);
        if(target == 0){
            List<Integer> copy = new ArrayList<>(tempList);
            Collections.sort(copy);
            if(!result.contains(copy)){
            result.add(new ArrayList<>(copy));
            }
            return;
        }
        if(target<0){
            return;
        }
        for(int i=0;i<candidates.length;i++){
            tempList.add(candidates[i]);
            func(result,candidates,target-candidates[i],tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}