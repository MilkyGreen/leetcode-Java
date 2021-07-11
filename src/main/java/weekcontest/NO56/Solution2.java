package weekcontest.NO56;

import java.util.ArrayDeque;

/**
 * <p>
 */
public class Solution2 {


    /**
     * bfs，广度优先搜索。每一次向四周走一步，第一个符合条件的即是最近的出口。
     * @param maze
     * @param entrance
     * @return
     */
    public int nearestExit(char[][] maze, int[] entrance) {

        // 访问记录，访问过的就不用再访问了
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        // 搜索队列
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(entrance); // 从起点开始
        for (int i = 0;!queue.isEmpty();i++){ // i 代表步数。每次同样步数的统一处理
            for (int j = queue.size();j>0;j--){ // 此时队列里全是这一轮的，循环处理。
                int[] remove = queue.removeFirst();
                if(remove[0] >= 0 && remove[0]<maze.length&&remove[1] >= 0 && remove[1] < maze[0].length && !visited[remove[0]][remove[1]] && maze[remove[0]][remove[1]] == '.'){
                    visited[remove[0]][remove[1]] = true;
                    if(i > 0 &&(remove[0] == 0 || remove[0] == maze.length-1 || remove[1] == 0 || remove[1] == maze[0].length-1) ){
                        return i;
                    }else {
                        // 将四个方向的添加入队列，由于j已经初始化过了，新增的元素会在i+1的时候被处理
                        queue.addLast(new int[]{remove[0] +1,remove[1]});
                        queue.addLast(new int[]{remove[0] ,remove[1] + 1});
                        queue.addLast(new int[]{remove[0] -1,remove[1]});
                        queue.addLast(new int[]{remove[0] ,remove[1]-1});
                    }
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        char[] i = {'+','+','.','+'};
        char[] i2 = {'.','.','.','+'};
        char[] i3 = {'+','+','+','.'};
        char[][] nums = {i,i2,i3};
        int[] e = {1,2};
        new Solution2().nearestExit(nums,e);
    }








    public int nearestExit2(char[][] maze, int[] entrance) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(entrance);
        for (int i = 0; !deque.isEmpty(); i++) {
            for (int j = deque.size(); j > 0; j--) {
                int[] remove = deque.remove();
                if (remove[0] >= 0 && remove[0] < maze.length && remove[1] >= 0 && remove[1] < maze[0].length
                        && maze[remove[0]][remove[1]] == '.' && !visited[remove[0]][remove[1]]) {
                    if (i > 0 && (remove[0] == 0 || remove[0] == maze.length - 1 || remove[1] == 0
                            || remove[1] == maze[0].length - 1)) {
                        return i;
                    } else {
                        visited[remove[0]][remove[1]] = true;
                        deque.add(new int[] { remove[0] - 1, remove[1] });
                        deque.add(new int[] { remove[0], remove[1] - 1 });
                        deque.add(new int[] { remove[0], remove[1] + 1 });
                        deque.add(new int[] { remove[0] + 1, remove[1] });
                    }
                }
            }
        }
        return -1;
    }
}
