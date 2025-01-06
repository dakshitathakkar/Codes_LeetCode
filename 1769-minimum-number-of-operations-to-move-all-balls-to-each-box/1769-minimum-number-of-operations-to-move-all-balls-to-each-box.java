class Solution {
    public int[] minOperations(String boxes) {
        
        char[] arr = boxes.toCharArray();
        int n = arr.length;
        int[] result = new int[n];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if((arr[i] - '0')==1){
                set.add(i);
            }
        }
        System.out.println(set);
        for(int i=0;i<n;i++){
            int sum=0;
            for(Integer j: set){
                sum+=Math.abs(j-i);
            }
            result[i] = sum;
        }
        return result;
    }
}