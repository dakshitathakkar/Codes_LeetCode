class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    int[] p = new int[2];
                    p[0] = i;
                    p[1] = j;
                    queue.add(p);
                }
            }
        }
        int[] dr = {0,-1,0,1};
        int[] dc = {-1,0,1,0};
        while(!queue.isEmpty()){
            int size = queue.size();
            
            boolean found = false;
            for(int i=0;i<size;i++){
                int[] p = queue.poll();
                
                for(int j=0;j<4;j++){
                    int calcR = p[0] + dr[j];
                    int calcC = p[1] + dc[j];
                    if(calcR<0 || calcR >=m || calcC<0 || calcC >=n || grid[calcR][calcC] == 0 || grid[calcR][calcC]==2){
                        continue;
                    }
                    else{
                        found=true;
                        
                        grid[calcR][calcC] = 2;
                        queue.add(new int[]{calcR,calcC});
                    }
                }
            }
            if(found) time++;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time;

    }
}