class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] vis = new int[n];
        canVisit(0,rooms.get(0),rooms, vis);
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                return false;
            }
        }
        return true;

    }

    public void canVisit(int i, List<Integer> room, List<List<Integer>> rooms, int[] vis){
        if(vis[i] == 1){
            return;
        }
        vis[i] = 1;
        for(Integer j: room){
            canVisit(j,rooms.get(j), rooms, vis);
        }
    }
}