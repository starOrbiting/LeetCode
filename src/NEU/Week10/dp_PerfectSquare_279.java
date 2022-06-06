package NEU.Week10;

public class dp_PerfectSquare_279 {
    public int numSquares(int n) {
        // 322 Coin Change类似，只不过279有1参与必有解，322有的会无解
        // 322是自顶向下，279使用自底向上
        // 思路：dp
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int mini = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                mini  = Math.min(mini, dp[i - j * j]);
            }
            dp[i] = mini + 1;
        }
        return dp[n];
    }
}
