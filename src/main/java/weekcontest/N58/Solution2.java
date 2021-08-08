package weekcontest.N58;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * <p>
 */
public class Solution2 {

    public static void main(String[] args) {
        char[][] bo = new char[8][8];
        bo[0] = new char[]{'B','B','B','.','W','W','B','W'};
        bo[1] = new char[]{'B','B','.','B','.','B','B','B'};
        bo[2] = new char[]{'.','W','.','.','B','.','B','W'};
        bo[3] = new char[]{'B','W','.','W','B','.','B','.'};
        bo[4] = new char[]{'B','W','W','B','W','.','B','B'};
        bo[5] = new char[]{'.','.','W','.','.','W','.','.'};
        bo[6] = new char[]{'W','.','W','B','.','W','W','B'};
        bo[7] = new char[]{'B','B','W','W','B','W','.','.'};
        System.out.println(new Solution2().checkMove(bo,5,6,'B'));
    }

    /**
     * [[],[],[],[],[],[],[],[]]
     * 5
     * 6
     * 'B'
     */
    //{,[],[],[],[

    char b = 'B';
    char w = 'W';
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        if(board[rMove][cMove] != '.'){
            return false;
        }
        return findDif(board, rMove, cMove, color);
    }

    private boolean findDif(char[][] board, int rMove, int cMove, char color){
        if(rMove>0){
            if(board[rMove-1][cMove] != '.' && board[rMove-1][cMove] != color){
                if(findSame(board,rMove-2,cMove,color,1)){
                    return true;
                }
            }
        }

        if(rMove<7){
            if(board[rMove+1][cMove] != '.' && board[rMove+1][cMove] != color){
                if(findSame(board,rMove+2,cMove,color,2)){
                    return true;
                }
            }
        }

        if(cMove>0){
            if(board[rMove][cMove-1] != '.' && board[rMove][cMove-1] != color){
                if(findSame(board,rMove,cMove-2,color,3)){
                    return true;
                }
            }
        }

        if(cMove<7){
            if(board[rMove][cMove+1] != '.' && board[rMove][cMove+1] != color){
                if(findSame(board,rMove,cMove+2,color,4)){
                    return true;
                }
            }
        }

        if(rMove>0 && cMove > 0){
            if(board[rMove-1][cMove-1] != '.' && board[rMove-1][cMove-1] != color){
                if(findSame(board,rMove-2,cMove-2,color,5)){
                    return true;
                }
            }
        }

        if(rMove>0 && cMove <7){
            if(board[rMove-1][cMove+1] != '.' && board[rMove-1][cMove+1] != color){
                if(findSame(board,rMove-2,cMove+2,color,6)){
                    return true;
                }
            }
        }

        if(rMove<7 && cMove > 0){
            if(board[rMove+1][cMove-1] != '.' && board[rMove+1][cMove-1] != color){
                if(findSame(board,rMove+2,cMove-2,color,7)){
                    return true;
                }
            }
        }

        if(rMove<7 && cMove <7){
            if(board[rMove+1][cMove+1] != '.' && board[rMove+1][cMove+1] != color){
                if(findSame(board,rMove+2,cMove+2,color,8)){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean findSame(char[][] board, int rMove, int cMove,char color,int direct){
        if(rMove >=0 && rMove <=7 && cMove>=0 && cMove<=7){
            if(board[rMove][cMove] == color){
                return true;
            }else if(board[rMove][cMove] == '.'){
                return false;
            }else {
                switch (direct){
                    case 1:
                        return findSame(board,rMove-1,cMove,color,direct);
                    case 2:
                        return findSame(board,rMove+1,cMove,color,direct);
                    case 3:
                        return findSame(board,rMove,cMove-1,color,direct);
                    case 4:
                        return findSame(board,rMove,cMove+1,color,direct);
                    case 5:
                        return findSame(board,rMove-1,cMove-1,color,direct);
                    case 6:
                        return findSame(board,rMove-1,cMove+1,color,direct);
                    case 7:
                        return findSame(board,rMove+1,cMove-1,color,direct);
                    case 8:
                        return findSame(board,rMove+1,cMove+1,color,direct);
                }
                return false;
            }
        }else {
            return false;
        }
    }

}
