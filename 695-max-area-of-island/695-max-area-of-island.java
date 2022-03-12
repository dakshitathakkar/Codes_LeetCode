class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // int m=grid.length;
        // int n = grid[0].length;
        // boolean[][] visited = new boolean[m][n];
        int maxArea=0;
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea,dfs(grid,i,j));
                }
            }
        }
        return maxArea;
    }
    public int dfs(int[][] grid, int r, int c){
        if(r>=0 && c>=0 && r<grid.length && c<grid[r].length&&grid[r][c]==1){
            grid[r][c] = 0;
        return 1+dfs(grid,r,c-1)+
        dfs(grid,r-1,c)+
        dfs(grid,r,c+1)+
        dfs(grid,r+1,c);
        }
            return 0;
        
    }
}