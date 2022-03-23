class Solution {
    public int closedIsland(int[][] grid) {
        if(grid.length == 0)
            return 0;
        int noOfClosedIslands = 0;
        int row = grid.length;
        int col = grid[0].length;
        
        for(int i=1; i<row-1; i++){
            for(int j=1; j<col-1; j++){
                if(grid[i][j] == 0){
                    if(isClosedIsland(grid,i,j))
                        ++noOfClosedIslands;
                }
            }
        }
        return noOfClosedIslands;
    }
    
    public boolean isClosedIsland(int[][]grid, int i, int j){
        if(grid[i][j] == 1 || grid[i][j] == -1)
            return true;
        if(i==0 || j==0 || i>=grid.length-1 || j>=grid[0].length-1)
            return false;
        grid[i][j] = -1;
        boolean left = isClosedIsland(grid,i-1,j);
        boolean right = isClosedIsland(grid,i+1,j);
        boolean up = isClosedIsland(grid,i,j-1);
        boolean down = isClosedIsland(grid,i,j+1);
        
        return left && right && up && down;
    }
}