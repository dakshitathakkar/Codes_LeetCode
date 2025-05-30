class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int max = 0;
        int[] count = new int[1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j] == 0 && grid[i][j]==1){
                    count[0] = 0;
                    dfs(i,j,m,n,vis,grid,count);
                    max = Math.max(max,count[0]);
                }
            }
        }
        return max;        
    }

    public void dfs(int i, int j, int m, int n, int[][] vis, int[][] grid, int[] count){
        if(i>=m || i<0 || j>= n || j<0 || vis[i][j] == 1 || grid[i][j] == 0){
            return;
        }
        vis[i][j] = 1;
        count[0]++;
        dfs(i,j-1,m,n,vis,grid,count);
        dfs(i-1,j,m,n,vis,grid,count);
        dfs(i,j+1,m,n,vis,grid,count);
        dfs(i+1,j,m,n,vis,grid,count);                
    }
}