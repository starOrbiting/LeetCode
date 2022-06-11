package NEU.Week11;

import java.util.ArrayList;
import java.util.List;

public class matrix_SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 思路1：模拟下一个方向
        // 重点：何时切换方向（出界，已访问过）
//        List<Integer> ans = new ArrayList<Integer>();
//        int m = matrix.length, n = matrix[0].length;
//        boolean[][] visit = new boolean[m][n];
//        int total = m * n;
//        int i = 0, j = 0;
//        int index = 0;
//        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
//        for (int k = 0; k < total; k++) {
//            visit[i][j] = true;
//            ans.add(matrix[i][j]);
//            int nextRow = i + direction[index][0];
//            int nextCol = j + direction[index][1];
//            // 换方向，走下一步
//            if (nextCol < 0 || nextCol >= n || nextRow < 0 || nextRow >= m || visit[nextRow][nextCol]){
//                index = (index + 1) % 4;
//            }
//            i += direction[index][0];
//            j += direction[index][1];
//        }
//        return ans;
        // 思路2：按层
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        List<Integer> ans = new ArrayList<Integer>();
        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            if (left < right && top < bottom){
                for (int i = right - 1; i >= left ; i--) {
                    ans.add(matrix[bottom][i]);
                }
                for (int i = bottom - 1; i > top; i--) {
                    ans.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}
