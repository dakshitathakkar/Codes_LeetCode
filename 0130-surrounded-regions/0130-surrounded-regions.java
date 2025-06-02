class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && board[0][j] == 'O'){
                   // System.out.println(i + " " + j);
                    dfs(i,j,m,n,vis,board);
                }
                else if(i == m-1 && board[m-1][j] == 'O'){
                   // System.out.println(i + " " + j);
                    dfs(i,j,m,n,vis,board);
                }

            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j == 0 && board[i][0] == 'O'){
                   // System.out.println(i + " " + j);
                    dfs(i,j,m,n,vis,board);
                }
                else if(j == n-1 && board[i][n-1] == 'O'){
                 //   System.out.println(i + " " + j);
                    dfs(i,j,m,n,vis,board);
                }

            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               // System.out.print(board[i][j] + " ");
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }

                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
           // System.out.println(" ");

        }

        
    
    }

    public void dfs(int i, int j, int m, int n, boolean[][] vis, char[][] board){
       
        if(i<0 || i>m-1 || j<0 || j> n-1 || vis[i][j] == true || board[i][j] == 'X'){
            return;
        }

        vis[i][j] = true;
        board[i][j] = '*';
        dfs(i,j-1,m,n,vis,board);
        dfs(i-1,j,m,n,vis,board);
        dfs(i,j+1,m,n,vis,board);
        dfs(i+1,j,m,n,vis,board);
    }
}