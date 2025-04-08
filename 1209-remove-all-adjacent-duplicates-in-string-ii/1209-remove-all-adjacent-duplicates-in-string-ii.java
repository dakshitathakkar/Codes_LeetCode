class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> charSt = new Stack<>();
        Stack<Integer> countSt = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!charSt.isEmpty() && charSt.peek() == ch){
                int count = countSt.pop();
                countSt.push(count+1);
            }
            else{
                countSt.push(1);
            }
            charSt.push(ch);
            if(countSt.peek()==k){
                for(int i=0;i<k;i++){
                    charSt.pop();
                }
                countSt.pop();
            }

        }
        StringBuilder sb=new StringBuilder();
        while(!charSt.isEmpty()) sb.insert(0,charSt.pop());
        return sb.toString();        
    }
}