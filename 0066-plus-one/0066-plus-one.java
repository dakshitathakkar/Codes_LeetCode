class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] res = new int[len+1];
           List<Integer> arr = new ArrayList<>();
        //909
        //910
        if(digits[len-1] != 9){
            digits[len-1] = digits[len-1]+1;
            return digits;
        }
        else{
           boolean flag = false;
           for(int i=len-1;i>=0;i--){
                if(digits[i] == 9 && !flag){
                    arr.add(0,0);
                    
                    if(i!=0){
                        if(digits[i-1]!=9){
                            arr.add(0,digits[i-1]+1);
                            i--;
                            flag = true;
                        }
                    }  
                    
                }
                else if(!flag){
                    arr.add(0,digits[i]+1);
                }
                else{
                    arr.add(0,digits[i]);
                }
           }
           if(arr.get(0) == 0){
            arr.add(0,1);
           }
            res = arr.stream().mapToInt(i -> i).toArray();
            
        }
        return res;
    }
}