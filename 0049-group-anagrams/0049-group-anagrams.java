class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] arr= strs[i].toCharArray();
            Arrays.sort(arr);
            String copy = new String(arr);
            if(!map.containsKey(copy)){
                map.put(copy,new ArrayList<>());
                
            }
            map.get(copy).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}