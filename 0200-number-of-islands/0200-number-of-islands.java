class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j] == 0 && grid[i][j]=='1'){
                    dfs(i,j,m,n,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, int m, int n, int[][] vis, char[][] grid){
        if(i>=m || i<0 || j>= n || j<0 || vis[i][j] == 1 || grid[i][j] == '0'){
            return;
        }
        vis[i][j] = 1;
        dfs(i,j-1,m,n,vis,grid);
        dfs(i-1,j,m,n,vis,grid);
        dfs(i,j+1,m,n,vis,grid);
        dfs(i+1,j,m,n,vis,grid);                
    }
}