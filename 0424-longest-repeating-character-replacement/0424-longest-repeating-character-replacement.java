class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int len = 0;
        int[] count = new int[26];
        int diff = 0;
        while(right<s.length()){
            diff = Math.max(diff, ++count[s.charAt(right) - 'A']);
            while(right-left+1-diff>k){
                 count[s.charAt(left) - 'A']--;
                left++;
            }
            len = Math.max(len,right-left+1);
            right++;
        }
        return len;
    }

}