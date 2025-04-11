class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int n = x;
       int reversed = 0;
       while(n > 0){
        int rem = n % 10;
        int tenPower = String.valueOf(n).length() - 1;
        int div = (int)Math.pow(10,tenPower);       
        reversed = reversed + (rem * div);
        n = n/10;
       }
       return reversed == x;
    }

    //121
    //121 % 10 = 1
    // div = 100
    //100
    //12
    //12%10 = 2
    //10*2 = 20 + 100 = 120
    //1

    //1221
    //1221 % 10 = 1
    //1221 / 1000 = 1
    //1221 - 1000 / 10  = 22
}