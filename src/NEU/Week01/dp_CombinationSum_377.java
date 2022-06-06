package NEU.Week01;

import java.util.Arrays;

public class dp_CombinationSum_377 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(combinationSum4(nums, 4));
    }

    public static int combinationSum4(int[] nums, int target) {
        /*
         * 思路2：自底向上
         * 构建dp[]，找边界dp[0]=1
         * 找关系dp[S]=sum(dp[S-nums[i]]) //可能无解为0
         */
        // 1. 创建dp[]，因为target>0,dp[0]可以做边界 dp[0]=1
        int[] dp = new int[target + 1];
        dp[0] = 1;
        int res;
        // 2. 推导、填充dp【有的dp[i]无解不存在，应该为0；有的有解，也是=f(S)=sum(dp[S-nums[i]])】
        for (int i = 1; i < target + 1; i++) {
            res = 0;
            for (int num : nums) {
                if (i >= num){
                    // 【i-num>=0】：（1）=0，返回1种方法（2）0<i-num<num, dp[i-num]都是0（3）num<=i-num，直接拿dp数组里保存的值
                    res += dp[i - num];
                }
            }
            dp[i] = res;
        }
        // 3. 即使nums[9],target=3的情况，dp[1]也为0
        return dp[target];

        /*
         * 思路1：自顶向下 递归
         * 使用storeCount数组保存结果，避免重复计算
         * f(S) = f(S - num1) + f(S - num2) +f(S - numN)
         */
//        int[] storeCount = new int[target];
//        Arrays.fill(storeCount, Integer.MIN_VALUE);
//        return combinationSum4(nums, target, storeCount);
    }

//    public static int combinationSum4(int[] nums, int rem, int[] storeCount){
//        // 1. 边界
//        // 无解返回0
//        if (rem < 0){
//            return 0;
//        }
//        // 有解
//        if (rem == 0){
//           return 1;
//        }
//        // 2. 判断是否计算过
//        if (storeCount[rem - 1] != Integer.MIN_VALUE){
//            return storeCount[rem - 1];
//        }
//        // 3. 没计算过，f(rem) = sum(f(rem -nums[i])) 遍历求和
//        int res = 0;
//        for (int num : nums) {
//            res += combinationSum4(nums, rem - num, storeCount);
//        }
//        storeCount[rem - 1] = res;
//        return res;
//    }

}
