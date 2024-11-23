class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (i1,i2) -> Integer.compare(i1[1],i2[1]));
        int count = 0;
        int[] compared = intervals[0];
        for(int i=1;i<n;i++){
            if(compared[1] <= intervals[i][0]){
                compared = intervals[i];
            }
            else{
                count++;
            }
        }
        return count;

    }
}