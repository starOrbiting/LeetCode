package NEU.Week03;

public class dp_BuySellStock02_122 {
    public int maxProfit(int[] prices) {
        /*
         * 思路：dp
         * （1）考虑到「不能同时参与多笔交易」，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
         * （2）dp[i][0]第i天没有股票获得的最大收益，dp[i][1]第i天有股票获得的最大收益，
         * （3）每一天的状态只与前一天的状态有关，而与更早的状态都无关
         */
        int[][]dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
