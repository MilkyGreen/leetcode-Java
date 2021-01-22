package p200.p130;

/**
 * //给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * //
 * // 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * //
 * // 示例:
 * //
 * // X X X X
 * //X O O X
 * //X X O X
 * //X O X X
 * //
 * //
 * // 运行你的函数后，矩阵变为：
 * //
 * // X X X X
 * //X X X X
 * //X X X X
 * //X O X X
 * //
 * //
 * // 解释:
 * //
 * // 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
 * //填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 */
public class Solution {

    int row;
    int col;
    public void solve(char[][] board) {

        if(board == null || board.length == 0){
            return;
        }

        row = board.length;
        col = board[0].length;
        if (row > 2 && col > 2) {
            // 先遍历边上的o，如果它相邻的也是个o，改为-(错误，不能只找相邻的，要继续往里找，相联通的都算)
            // 第一行
            for (int i = 1; i < col-1; i++) {
                /*char c = board[0][i];
                if (c == 'O') {
                    dfs(board,1,i);
                }
                */
                dfs(board,0,i);
                dfs(board,row - 1,i);
            }
            // 最后一行
            /*for (int i = 1; i < col-1; i++) {
                char c = board[row - 1][i];
                if (c == 'O') {
                    if (board[row - 2][i] == 'O') {
                        board[row - 2][i] = '-';
                    }
                }
            }*/

            // 列
            for (int i = 1; i < row-1; i++) {
                /*char c = board[i][0];
                if (c == 'O') {
                    if (board[i][1] == 'O') {
                        board[i][1] = '-';
                    }
                }*/
                dfs(board,i,0);
                dfs(board,i,col-1);
            }

            /*for (int i = 1; i < row-1; i++) {
                char c = board[i][col - 1];
                if (c == 'O') {
                    if (board[i][col - 2] == 'O') {
                        board[i][col - 2] = '-';
                    }
                }
            }*/

            // 把剩余的O变成X
            for (int i = 1; i < row-1; i++) {
                for (int j = 1; j < col-1; j++) {
                    if(board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }
                }
            }

            // 把之前改成-的O复原
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(board[i][j] == '-'){
                        board[i][j] = 'O';
                    }
                }
            }
        }
    }

    // 先把外层已经相关联的O改成-
    private void dfs(char[][] board,int i,int j){
        if(i >= row || j >= col || i < 0 || j < 0 || board[i][j] != 'O'){
            return;
        }
        board[i][j] = '-';
        // 如果是O，向四个方向分别前进
        dfs(board,i-1,j);
        dfs(board,i,j-1);
        dfs(board,i+1,j);
        dfs(board,i,j+1);

    }

}
