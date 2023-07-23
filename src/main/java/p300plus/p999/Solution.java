package p300plus.p999;

public class Solution {
    public int numRookCaptures(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int rookRow = 0;
        int rookCol = 0;
outter:for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(board[i][j] == 'R'){
                    rookRow = i;
                    rookCol = j;
                    break outter;
                }
            }
        }

        int res = 0;

        for(int row = rookRow - 1;row >= 0;row--){
            if(board[row][rookCol] == 'B'){
                break;
            }
            if(board[row][rookCol] == 'p'){
                res++;
                break;
            }
        }

        for(int row = rookRow + 1;row < rows;row++){
            if(board[row][rookCol] == 'B'){
                break;
            }
            if(board[row][rookCol] == 'p'){
                res++;
                break;
            }
        }

        for(int col = rookCol-1;col >= 0;col--){
            if(board[rookRow][col] == 'B'){
                break;
            }
            if(board[rookRow][col] == 'p'){
                res++;
                break;
            }
        }

        for(int col = rookCol+1;col < cols;col++){
            if(board[rookRow][col] == 'B'){
                break;
            }
            if(board[rookRow][col] == 'p'){
                res++;
                break;
            }
        }

        return res;
    }
}
