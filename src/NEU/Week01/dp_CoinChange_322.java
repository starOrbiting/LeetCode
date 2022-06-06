package NEU.Week01;


public class dp_CoinChange_322 {
    public static void main(String[] args) {
        int[] coins1 = new int[]{1, 2, 5};
        int[] coins2 = new int[]{2};
        int[] coins3 = new int[]{1};
        System.out.println(coinChange(coins1, 11));
        System.out.println(coinChange(coins2, 3));
        System.out.println(coinChange(coins3, 0));
    }
    public static int coinChange(int[] coins, int amount) {
        /*
         * 知识点：动态规划
         * （1）自顶向下【递归 存储每一个计算过的值】避免重复计算 Fibonacci
         * （2）自底向上【从最小子问题计算，保存先计算的值，为后面的计算服务】
         */
        /*
         * 思路1：自底向上
         * （1）假设：S为当前总额，有c1、c2、cn的硬币。
         * （2）F(S) = min(F(s-c1)+1, F(s-c2)+1, F(s-cn)+1) // 当总额为S时，最少硬币数
         * （3）开始从最小子问题计算：F(0)=0，顺序填满F(0)~F(S)，最后判断F(S)是否有解
         * 注意：
         * （1）F(0)~F(S)的初始值设置 S+1 //
         * （2）有的F(s1)没有解，怎么赋值？还是S+1
         * （3）最后的F(S)是否有解
         */
//        int[] dp = new int[amount + 1];
//        // 最大个数只可能是amount，赋值amount+1很妙
//        Arrays.fill(dp, amount + 1);
//        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (i >= coins[j]) {
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                }
//            }
//        }
//        return dp[amount] > amount ? -1 : dp[amount];
        /*
         * 思路2：自顶向下
         * 假设amount=5，coins=[3]
         * 拆解如下：F(5)->F(2)->F(-1)递归；返回值如下：-1 -> 因为(minCount==MAX_VALUE) -1 -> -1
         */
        if (amount == 0) {
            return 0;
        }
        return coinChange2(coins, amount, new int[amount]);

    }
    // rem: 当前剩余额度，storeCount存放之前递归已经计算过的值
    public static int coinChange2(int[] coins, int rem, int[] storeCount) {
        // 边界条件
        if (rem < 0){
            return -1; // 无解
        }
        if (rem == 0){
            return 0;
        }
        // （1）是否以前计算过，如果计算过：要么无解==-1；要么有解>=1；
        // 等于0说明没有计算过，或者也可以用Integer.MAX_VALUE
        if (storeCount[rem - 1] != 0){
            return storeCount[rem - 1];
        }
        // （2）没有计算过，继续递归
        int res;
        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            res = coinChange2(coins, rem - coin, storeCount);
            // 有解的情况下，更新最少个数
            if (res >= 0) {
                //res = Math.min(minCount, res);
                minCount = Math.min(minCount, res + 1);
            }
        }
        // （3）当前rem额度 无解的话，minCount还是MAX_VALUE
        storeCount[rem - 1] = (minCount == Integer.MAX_VALUE) ? -1 : minCount;
        return storeCount[rem - 1];

    }
}
