class Solution {
    public int compress(char[] chars) {
        List<Character> list = new ArrayList<>();
        int n = chars.length;
        if(chars.length == 1){
            return 1;
        }

        for(int i=1;i<n;i++){
            list.add(chars[i-1]);
            int count = 1;
            while(i<n && chars[i] == chars[i-1]){
                count++;
                i++;
            }
            if(count!=1){
                String c = String.valueOf(count);              
                for(int j=0;j<c.length();j++) {
                    list.add(c.charAt(j));
                }
            }
        }
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            chars[i] = list.get(i);
        }

        return list.size();
    }
}