class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;
        int k=0, l=0, i=0;
        while(k<r && l<c){
            for(i=l;i<c;i++){
                res.add(matrix[k][i]);
            }
            k++;
            for(i=k;i<r;i++){
                res.add(matrix[i][c-1]);
            }
            c--;
            if(k<r){
                for(i=c-1;i>=l;i--){
                    res.add(matrix[r-1][i]);
                }
                r--;
            }
            if(l<c){
                for(i=r-1;i>=k;i--){
                    res.add(matrix[i][l]);
                }
                l++;
            }
        }
        return res;
    }
}