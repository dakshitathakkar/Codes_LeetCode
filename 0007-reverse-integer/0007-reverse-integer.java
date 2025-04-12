class Solution {
    public int reverse(int x) {
        long n = Math.abs(x);
        long reversed = 0;
        while (n > 0) {
            long rem = n % 10;
            int tenPower = String.valueOf(n).length() - 1;
            int div = (int) Math.pow(10, tenPower);
            reversed = reversed + (rem * div);
            n = n / 10;
        }
        if(reversed > Integer.MAX_VALUE)    return 0;
        if(x<0){
            return (int)reversed*-1;
        }
        return (int)reversed;
    }
}