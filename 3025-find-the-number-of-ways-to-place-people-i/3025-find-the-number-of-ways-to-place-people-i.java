class Solution {
    public int numberOfPairs(int[][] points) {
        int res = 0;
        int n = points.length;
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); 
            }
            return Integer.compare(b[1], a[1]);     
        });
        for(int i=0;i<n;i++){
            int min = Integer.MIN_VALUE;
            for(int j=i+1;j<n;j++){
                
                if(points[i][1]>=points[j][1] && min < points[j][1]){
                    res++;
                    min = points[j][1];
                    if(min == points[i][1]) break;
                }
            }
        }
        return res;
    }
}