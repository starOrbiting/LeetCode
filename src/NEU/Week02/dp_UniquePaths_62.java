package NEU.Week02;

public class dp_UniquePaths_62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(23,12));
    }
    public static int uniquePaths(int m, int n) {
        /*
         * 思路1：dp
         * （1）创建dp[][]二维数组，dp[m-1][n-1]为最终结果
         * （2）转移方程f(i,j)=f(i-1,j)+f(i,j-1)
         * （3）初始边界f(0,0)=1,f(i,0)=1,f(0,j)=1
         */
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = 1;
//        }
//        for (int j = 0; j < n; j++) {
//            dp[0][j] = 1;
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
//        return dp[m - 1][n - 1];
        /*
         * 思路2：组合
         * （m，n）一共要走（m+n-2）步，在里面选（m-1）步
         * =(m+n-2)! / (m-1)!(n-2)!
         */
        long ans = 1;
        for (int i = n, j = 1; i <= m + n - 2; i++, j++) {
            ans = ans * i / j;
        }
        return (int) ans;

    }
}
