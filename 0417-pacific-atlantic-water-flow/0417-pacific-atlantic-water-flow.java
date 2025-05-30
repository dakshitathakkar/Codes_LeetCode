class Solution {
    int[] delrow = {0,-1,0,1};
    int[] delcol = {-1,0,1,0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pacific[0][j] = true;
                pacific[i][0] = true;
                atlantic[m-1][j] = true;
                atlantic[i][n-1] = true;
            }
        }
        // System.out.println("pacific");
        bfs(heights,pacific,m,n);
        // System.out.println("atlantic");
        bfs(heights,atlantic,m,n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // System.out.println(pacific[i][j] + " pacific" + i + " " + j);
                //  System.out.println(atlantic[i][j] + "atlantic" + i + " " + j);
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> indexList = new ArrayList<>();
                    indexList.add(i);
                    indexList.add(j);
                    res.add(indexList);
                }
            }
        }
        return res;
    }

    public void bfs(int[][] heights, boolean[][] vis, int m, int n){
        Queue<List<Integer>> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]){
                    List<Integer> indexList = new ArrayList<>();
                    indexList.add(i);
                    indexList.add(j);
                    q.add(indexList);
                }
            }
        }
        while(!q.isEmpty()){
            int row = q.peek().get(0);
            int col = q.peek().get(1);
            // System.out.println(row + " " + col);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];
                //  System.out.println(nrow + " " + ncol);
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n &&
                    !vis[nrow][ncol] && heights[row][col] <= heights[nrow][ncol]){
                        vis[nrow][ncol] = true;
                        List<Integer> indexList = new ArrayList<>();
                        indexList.add(nrow);
                        indexList.add(ncol);
                        q.add(indexList);
                    }
            }
            // System.out.println("=---");
        }
    }
}