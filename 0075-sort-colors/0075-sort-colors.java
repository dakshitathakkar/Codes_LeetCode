class Solution {
    public void sortColors(int[] nums) {
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)    countZero++;
            else if(nums[i]==1) countOne++;
            else    countTwo++;
        }

        int idx = 0;
        while(idx<nums.length){
            while(countZero>0){
                nums[idx] = 0;
                idx++;
                countZero--;
            }
            while(countOne>0){
                nums[idx] = 1;
                idx++;
                countOne--;
            }
            while(countTwo>0){
                nums[idx] = 2;
                idx++;
                countTwo--;
            }
        }
    }
}