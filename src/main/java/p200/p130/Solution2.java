package p200.p130;

public class Solution2 {
    char x = 'X';
    char o = 'O';
    char z = 'Z';
    char[][] board;
    int m;
    int n;
    int[][] ds = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        this.board = board;

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    mark(i, j);
                }
            }
        }

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == o){
                    board[i][j] = x;
                }
            }
        }

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == z){
                    board[i][j] = o;
                }
            }
        }

    }

    void mark(int i,int j){
        if(i < 0 || i == m || j < 0 || j == n){
            return;
        }
        if(this.board[i][j] == o){
            this.board[i][j] = z;
        }else if(this.board[i][j] == x || this.board[i][j] == z){
            return;
        }
        for(int[] d : ds){
            mark(i + d[0],j+d[1]);
        }
    }
}
