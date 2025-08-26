class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double max = 0;
        int idx = 0;
        for(int i=0;i<dimensions.length;i++){
            double sqrt = Math.sqrt((dimensions[i][0] * dimensions[i][0]) + (dimensions[i][1]*dimensions[i][1]));
            if(sqrt>max){
                max = sqrt;
                idx = i;
            }
            else if(sqrt == max){
                int area1 = dimensions[i][0]*dimensions[i][1];
                int area2 = dimensions[idx][0]*dimensions[idx][1];
                if(area1>area2){
                    idx=i;
                }
            }
        }
        return dimensions[idx][0]*dimensions[idx][1];
    }
}