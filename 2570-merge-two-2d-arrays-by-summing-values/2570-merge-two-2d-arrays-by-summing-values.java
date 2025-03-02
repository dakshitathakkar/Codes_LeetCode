class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<n;i++){
            map.put(nums1[i][0],nums1[i][1]);
        }

        for(int i=0;i<m;i++){
            map.put(nums2[i][0],map.getOrDefault(nums2[i][0],0)+nums2[i][1]);
        }
       
        int[][] result = new int[map.size()][2];
        int idx = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            result[idx][0] = entry.getKey();
            result[idx][1] = entry.getValue();
            idx++;
        }
        return result;
    }
}