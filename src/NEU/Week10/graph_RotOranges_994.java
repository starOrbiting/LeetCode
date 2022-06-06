package NEU.Week10;

import java.util.LinkedList;
import java.util.Queue;

public class graph_RotOranges_994 {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        // 思路：多源BFS
        // 把坏橙子放在初始同一层，BFS遍历，过滤点，比较橙子数是否一致（不一致即有好橙子）
        // 特别地：没有橙子时，layer=0
        int count = 0;
        int sum = 0;
        Queue<Integer> X = new LinkedList<Integer>();
        Queue<Integer> Y = new LinkedList<Integer>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0){
                    sum++;
                }
                if (grid[i][j] == 2){
                    X.add(i);
                    Y.add(j);
                }
            }
        }
        if (sum == 0){
            return 0;
        }

        //
        int size = 0;
        int layer = -1;
        while (!X.isEmpty()){
            size = X.size();
            layer++;
            for (int i = 0; i < size; i++) {
                int cur_X = X.poll();
                int cur_Y = Y.poll();
                // 进队列的都是有效、不重复点，所以不用过滤
                count++;
                int[] di = {0,0,-1,1};
                int[] dj = {-1,1,0,0};
                for (int index = 0; index < 4; index++) {
                    int add_X = cur_X + di[index];
                    int add_Y = cur_Y + dj[index];
                    // 进队列前先过滤出界、0无效 2起始点 都不能添加进队列
                    if (add_X <0 || add_Y < 0 || add_X >= grid.length || add_Y >= grid[0].length || grid[add_X][add_Y] != 1){
                        continue;
                    }
                    else{
                        X.add(add_X);
                        Y.add(add_Y);
                        // 不添加重复点
                        grid[add_X][add_Y] = 0;
                    }
                }


            }
        }

        return count == sum ? layer : -1;

    }
}
