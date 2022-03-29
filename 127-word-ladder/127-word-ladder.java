class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word: wordList){
            set.add(word);
        }
        if(!set.contains(endWord))
            return 0;
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int depth = 0;
        while(!q.isEmpty()){
            depth +=1;
            int lsize = q.size();
            while(lsize-- > 0){
                String curr = q.poll();
                for(int i=0; i<curr.length(); i++){
                    char[] a = curr.toCharArray();
                    for(char c = 'a'; c<='z'; c++){
                        a[i] = c;
                        String temp = new String(a);
                        if((curr.compareTo(temp))==0)
                            continue;
                        if((temp.compareTo(endWord))==0)
                            return depth+1;
                        if(set.contains(temp)){
                            q.add(temp);
                            set.remove(temp);
                        }
                    }
                }
            }
        }
        return 0;
    }
}