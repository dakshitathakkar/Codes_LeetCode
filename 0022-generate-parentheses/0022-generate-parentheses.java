class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        func("",0,0,n,res);
        return res;
    }

    private void func(String s, int open, int close, int n, List<String> res){
        
        if(open<n){
            func(s+"(",open+1,close,n,res);
        }
        if(close<open){
            func(s+")",open,close+1,n,res);
        }
        
        if(s.length()==n*2){
            res.add(s);
            return;
        }
    }

}