class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        int n = s.length();
        int[] count= new int[3];
        Arrays.fill(count,0);
        while(right < n){
            ++count[s.charAt(right) - 'a'];
            while(count[0] >0 && count[1] >0  && count[2] >0){
                --count[s.charAt(left++) - 'a'];
               
            }
            res = res + left;
            right++;
        }
        return res;
    }
}