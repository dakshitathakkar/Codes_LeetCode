class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxCount = 0;
        for(Integer item : set){
            int n = item;
            int count = 1;
            if(map.containsKey(n-1)){
                count +=map.get(n-1);
            }
            if(map.containsKey(n+1)){
                count +=map.get(n+1);
            }
            while(map.containsKey(n-1)){
                map.put(n-1,count);
                n--;
            }
            while(map.containsKey(n+1)){
                map.put(n+1,count);
                n++;
            }
            map.put(item,count);
            maxCount = Math.max(count,maxCount);

        }
        return maxCount;
    }
}