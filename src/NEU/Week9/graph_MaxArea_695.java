package NEU.Week9;

import java.util.Deque;
import java.util.LinkedList;

public class graph_MaxArea_695 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1},{1,1,0},{0,1,1}};
        System.out.println(maxAreaOfIsland(grid));
    }
    public static int maxAreaOfIsland(int[][] grid) {
        // 思路1：递归DFS
//        int maxArea = 0;
//        int temp;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] != 0){
//                    temp = DFS_01(grid, i, j);
//                    maxArea = Math.max(temp, maxArea);
//                }
//            }
//        }
//        return maxArea;
//    }
//    public int DFS_01(int[][] grid, int i, int j){
//        // 超出边界
//        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
//            return 0;
//        }
//        // visited置0，递归上下左右
//        if (grid[i][j] != 0){
//            grid[i][j] = 0;
//            return 1 + DFS_01(grid,i,j-1)+ DFS_01(grid,i,j+1)+ DFS_01(grid,i-1,j)+ DFS_01(grid,i+1,j);
//        }
//        else {
//            return 0;
//        }
        // 思路2：栈DFS
//        int maxArea = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] != 0){
//                    maxArea = Math.max(maxArea, DFS(grid,i,j));
//                }
//            }
//        }
//        return maxArea;
//    }
//    public int DFS(int[][] grid, int i, int j){
//        int count = 0;
//        Stack<Integer> sX = new Stack<Integer>();
//        Stack<Integer> sY = new Stack<Integer>();
//        sX.push(i);
//        sY.push(j);
////        count++;
////        grid[i][j] = 0;
//        // 有效点判断方式：（1）进栈前判断是否有效，直接进下一步，4次if （2）出栈后判断，有效的才进行下一步，1次
//        while (!sX.isEmpty()){
//            int cur_i = sX.pop();
//            int cur_j = sY.pop();
//            // 过滤 无效出界点+非1
//            if (cur_i < 0 || cur_j <0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] == 0){
//                continue;
//            }
//            // 有效点
//            count++;
//            grid[cur_i][cur_j] = 0;
//            // 4个方向入栈
//            int[] di = {0,0,-1,1};
//            int[] dj = {-1,1,0,0};
//            for (int k = 0; k < 4; k++) {
//                sX.push(cur_i + di[k]);
//                sY.push(cur_j + dj[k]);
//            }
//        }
//        return count;
        // 思路3：队列BFS
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0){
                    maxArea = Math.max(maxArea, BFS(grid,i,j));
                }

            }
        }
        return maxArea;
    }
    public static int BFS(int[][] grid, int i, int j) {
        int count = 0;
        Deque<Integer> qX = new LinkedList<>();
        Deque<Integer> qY = new LinkedList<>();
        qX.add(i);
        qY.add(j);
        int size;
        while (!qX.isEmpty()){
            size = qX.size();
            for (int k = 0; k < size; k++) {
                int cur_i = qX.pop();
                int cur_j = qY.pop();
                // 过滤掉出界、无效、有效后无效点，所以添加重复点不会重数
                if (cur_i < 0 || cur_j <0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] == 0){
                    continue;
                }
                count++;
                grid[cur_i][cur_j] = 0;
                // 此处会添加重复的点
                int[] di = {0,0,-1,1};
                int[] dj = {-1,1,0,0};
                for (int index = 0; index < 4; index++) {
                    qX.add(cur_i + di[index]);
                    qY.add(cur_j + dj[index]);
                }
            }
        }
        return count;
    }
}
