package p100.p0079;

import java.util.Stack;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * <p>
 * Copyright: Copyright (c) 2020/7/23 19:14
 * <p>
 * <p>
 *
 * @version 1.0.0
 */
public class Solution {

    /**
     * 思路：感觉是全排列的思路，每个字母都作为起点，上下左右作为下一个，再下一个，直到遍历完。
     * 几个要点：
     * 1、记录dfs的深度n，比较当前的字符与字符串第n个位置字符是否一样，不一样直接return，省去了用stack保存path的操作。
     * 2、traceBack直接返回结果，如果为true直接结束即可，不用通过全局的result变量判断。
     *
     * @param board
     * @param word
     * @return
     */

    // 行数
    int col;
    // 列数
    int row;

    // 由于字母不能重复用，要标识一下是否用过
    boolean[][] used;

    char[] ws;
    char[][] board;

    public boolean exist(char[][] board, String word) {

        this.row = board.length;
        this.col = board[0].length;
        used = new boolean[row][col];
        ws = word.toCharArray();
        this.board = board;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == ws[0]){
                    if(traceBack(i,j,0)){
                        return true;
                    }else {
                        used[i][j] = false;
                    }
                }
            }
        }
        return false;
    }

    private boolean traceBack(int currRow, int currCol,int index) {

        // 与字符串指定位置是否一样
        if(board[currRow][currCol] != ws[index]){
            return false;
        }

        // 长度一样，证明找到了
        if(index == ws.length-1){
            return true;
        }

        // 标记使用过
        used[currRow][currCol] = true;

        // 继续增加下一个字符，有上下左右四个方向
        if (hasNext(currRow - 1, currCol)) {
            if(traceBack( currRow - 1, currCol, index+1)){
                return true;
            }else {
                // 清除这次的使用痕迹
                used[currRow - 1][currCol] = false;
            }
        }

        if (hasNext(currRow + 1, currCol)) {
            if(traceBack( currRow + 1, currCol, index+1)){
                return true;
            }else {
                used[currRow + 1][currCol] = false;
            }
        }

        if (hasNext(currRow, currCol - 1)) {

            if(traceBack( currRow , currCol - 1, index+1)){
                return true;
            }else {
                used[currRow][currCol - 1] = false;
            }
        }

        if (hasNext(currRow, currCol + 1)) {
            if(traceBack( currRow , currCol + 1, index+1)){
                return true;
            }else {
                used[currRow][currCol + 1] = false;
            }
        }

        return false;
    }

    private boolean hasNext(int currRow, int currCol) {
        // 判断下个位置是否合法
        if (currRow < 0 || currRow >= row || currCol < 0 || currCol >= col) {
            return false;
        } else {
            // 判断位置是否用过了
            return !used[currRow][currCol];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(solution.exist(board, "ABCB"));
    }

}
