package NEU.Week10;

import java.util.LinkedList;
import java.util.Queue;

public class graph_Matrix_542 {
    public int[][] updateMatrix(int[][] mat) {
        // 思路：多源BFS
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] visit = new boolean[m][n]; //默认false
        Queue<int[]> queue = new LinkedList<int[]>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0){
                    queue.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};
        while (!queue.isEmpty()){
            // 此处可以省略size，直接poll，因为不需要对层做操作（求层数），只需要递推下一元素
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int curi = cell[0];
                int curj = cell[1];
                for (int j = 0; j < 4; j++) {
                    int di = curi + dx[j];
                    int dj = curj + dy[j];
                    // true是遍历过
                    if (di < 0 || dj < 0 || di >= m || dj >= n || visit[di][dj]){
                        continue;
                    }
                    dist[di][dj] = dist[curi][curj] + 1;
                    queue.offer(new int[]{di, dj});
                    visit[di][dj] = true;
                }
            }
        }
        return dist;
    }
}
