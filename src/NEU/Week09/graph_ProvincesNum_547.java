package NEU.Week09;

public class graph_ProvincesNum_547 {
    public int findCircleNum(int[][] isConnected) {
        // 思路：图的遍历
        // 每次遇到一个新的图，可以DFS BFS
        int N = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]){
                DFS(isConnected, visited,i);
                count++;
            }
        }
        return count;
    }
    public void DFS(int[][] grid, boolean[] visited, int i){
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 1 && !visited[j]){
                visited[j] = true;
                DFS(grid,visited,j);
            }
        }
    }
}
