class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end = Math.max(end,intervals[i][1]);
            }
            else{
                int[] temp = new int[2];
                temp[0] = start;
                temp[1] = end;
                list.add(temp);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        int[] temp = new int[2];
        temp[0] = start;
        temp[1] = end;
        list.add(temp);
        int[][] res = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}