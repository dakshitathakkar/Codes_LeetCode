// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
        // Code here
    }
    public void dfs(char[][] grid, int row, int col, boolean[][] visited){
        if(row<0 || col<0 || row>=grid.length || col>=grid[row].length || visited[row][col] || grid[row][col] == '0'){
            return;
        }
        visited[row][col] = true;
        dfs(grid,row,col-1,visited);
        dfs(grid,row-1,col,visited);
        dfs(grid,row,col+1,visited);
        dfs(grid,row+1,col,visited);
        dfs(grid,row-1,col-1,visited);
        dfs(grid,row-1,col+1,visited);
        dfs(grid,row+1,col+1,visited);
        dfs(grid,row+1,col-1,visited);
    }
}