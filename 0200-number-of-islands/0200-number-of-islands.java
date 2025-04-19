class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] vis = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    func(i,j,m,n,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }

    public void func(int i, int j, int m, int n, char[][] grid, int[][] vis){
        if(i<0 || j< 0 || i>=m || j>=n || vis[i][j] ==1 || grid[i][j] == '0'){
            return;
        }
        vis[i][j] = 1;
        func(i-1,j,m,n,grid,vis);
        func(i,j+1,m,n,grid,vis);
        func(i+1,j,m,n,grid,vis);
        func(i,j-1,m,n,grid,vis);
        

    }
}