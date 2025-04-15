class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         Stack<Integer> idxSt = new Stack<>();
         int n = temperatures.length;
         int[] result = new int[n];
         idxSt.push(0);
         for(int i=1;i<n;i++){
            while(!idxSt.isEmpty() && temperatures[i] > temperatures[idxSt.peek()]){
                int idx = idxSt.pop();
                result[idx] = i-idx; 
            }
            idxSt.push(i);
         }
         result[n-1] = 0;
         return result;
    }
}