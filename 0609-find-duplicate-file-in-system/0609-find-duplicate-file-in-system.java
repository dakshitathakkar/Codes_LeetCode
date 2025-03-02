class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String path : paths){
            String[] splits = path.split("\\s");
            for(int i = 1; i<splits.length; i++){
                int bracket = splits[i].indexOf("(");
                String content = splits[i].substring(bracket);
                String name = splits[0] + "/" + splits[i].substring(0,bracket);
                if(!map.containsKey(content)){
                    map.put(content,new ArrayList<>());
                }
                map.get(content).add(name);
            }
        }

        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            if(entry.getValue().size() > 1){
                result.add(entry.getValue());
            }
        }

        return result;
    }
}