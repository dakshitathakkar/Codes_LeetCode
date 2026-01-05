class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sumArray = 0;
        long min = Long.MAX_VALUE;
        int countNeg = 0;
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sumArray +=Math.abs(matrix[i][j]);
                if(matrix[i][j]<0)  countNeg++;
                min = Math.min(min,Math.abs(matrix[i][j]));
            }
        }
        if(countNeg%2!=0){
            return sumArray - (2*min);
        }
        return sumArray;
    }
}