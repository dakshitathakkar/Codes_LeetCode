class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int dist = (int)Math.pow(points[i][0],2) + (int)Math.pow(points[i][1],2);
            //System.out.println(dist);
            pq.add(dist);
            if(!map.containsKey(dist)){
                map.put(dist,new ArrayList<>());
            }
            map.get(dist).add(i);
        }

        int[][] result = new int[k][2];
        int i=0;
        while(k>0){
            int dist = pq.poll();

            for(int j=0;j<map.get(dist).size();j++){
                int idx = map.get(dist).get(j);
                result[i][0] = points[idx][0];
                result[i][1] = points[idx][1];

            i++;
            k--;
            }

        }
        return result;
    }
}