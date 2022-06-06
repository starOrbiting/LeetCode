package NEU.Week01;

import java.util.Arrays;

public class dp_LongestIncreaseSubseq_300 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        /*
         * 动态规划 dp 自底向上
         * 个人感觉：就是从最小子问题开始向上填充dp[]，
         * 重要：如何找到子问题间的关系，进一步推导？？
         */
        int maxLen = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        // （1）计算填充dp[]
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // （2）如果当前元素 比前面某个元素大时：获得他的子串，长度+1，
                // 有的子串长，有的子串短，取max()
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // （3）出内循环时，已经得到dp[i]的值，更新全局最大长度maxLen
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
