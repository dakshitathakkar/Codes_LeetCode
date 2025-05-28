class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        int maxLength = 0;
        int length = 0;
        int lastOccuredIdx = -1;
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i]) && lastOccuredIdx < map.get(array[i])){
                length = i - map.get(array[i]);
                lastOccuredIdx = map.get(array[i]);
            }
            else{
                length++;
            }
            map.put(array[i],i);
            maxLength = Math.max(maxLength,length);
        }
        return maxLength;
    }
}