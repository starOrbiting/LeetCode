package NEU.Week10;

import java.util.LinkedList;
import java.util.Queue;

public class graph_ShortestPath_1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // 思路：图的DFS
        int N = grid.length;
        if (grid[N-1][N-1] == 1 || grid[0][0] == 1){
            return -1;
        }

        Queue<Integer> pX = new LinkedList<Integer>();
        Queue<Integer> pY = new LinkedList<Integer>();
        pX.add(0);
        pY.add(0);
        grid[0][0] = 1;
        int layer = 0;
        while (!pX.isEmpty()){
            layer++;
            int size = pX.size();
            for (int i = 0; i < size; i++) {
                int cur_X = pX.poll();
                int cur_Y = pY.poll();
                if (cur_X == N-1 && cur_Y == N - 1){
                    return layer;
                }


                int[] di = {0,0,-1,1,-1,-1,1,1};
                int[] dj = {-1,1,0,0,-1,1,-1,1};
                for (int index = 0; index < di.length; index++) {
                    int add_X = cur_X + di[index];
                    int add_Y = cur_Y + dj[index];
                    if (add_X < 0 || add_Y < 0 || add_X >= N || add_Y >= N || grid[add_X][add_Y] != 0){
                        continue;
                    }
                    pX.add(add_X);
                    pY.add(add_Y);
                    // 避免添加重复点
                    grid[add_X][add_Y] = 1;
                }

            }
        }
        return -1;
    }

}
