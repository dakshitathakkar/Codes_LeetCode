class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        int n = strs.length;
        for(int i=0;i<n;i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);
            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<>());
            }
            map.get(sorted).add(strs[i]);
        }

        List<List<String>> result = new ArrayList<>();
        for(String key: map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}