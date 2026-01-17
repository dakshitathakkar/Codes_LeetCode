class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxArea = 0;
        for(int i=0;i<n;i++){
            int[] leftPair1 = bottomLeft[i];
            int[] rightPair1 = topRight[i];
            for(int j=0;j<n;j++){
                if(i!=j){
                    // System.out.println();
                    // System.out.println(leftPair1[0] + " " + leftPair1[1]);
                    // System.out.println(rightPair1[0] + " " + rightPair1[1]);
                    int[] leftPair2 = bottomLeft[j];
                    int[] rightPair2 = topRight[j];
                    // System.out.println(leftPair2[0] + " " + leftPair2[1]);
                    // System.out.println(rightPair2[0] + " " + rightPair2[1]);
                    int minx = Math.max(leftPair1[0],leftPair2[0]);
                    int maxX = Math.min(rightPair1[0],rightPair2[0]);
                    int miny = Math.max(leftPair1[1],leftPair2[1]);
                    int maxy = Math.min(rightPair1[1],rightPair2[1]);
                    long length = Math.min(maxX-minx,maxy-miny);
                    if(length<0){
                        continue;
                    }
                    maxArea = Math.max(maxArea,length*length);
                    // System.out.println(length + " " + maxArea);
                }
            }
        }

        return maxArea;
    }
}