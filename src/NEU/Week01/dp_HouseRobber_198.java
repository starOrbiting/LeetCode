package NEU.Week01;

public class dp_HouseRobber_198 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,10,1};
    }
    public static int rob(int[] nums) {
        /*
         * 思路：自底向上dp
         * f(k)表示到[0~k]家，得到的最大金额
         * f(k)=max(f(k-1),f(k-2)+nums[k])
         */
        if (nums.length < 2){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];

    }
}
