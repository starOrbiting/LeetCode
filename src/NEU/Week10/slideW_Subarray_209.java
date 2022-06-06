package NEU.Week10;

public class slideW_Subarray_209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        // 思路1：滑动窗口
//        int l = 0, r = 0;
//        int mini = Integer.MAX_VALUE;
//        int temp = 0;
//        while (r < nums.length){
//            //（1）不断扩大窗口直到>=target
//            if (temp < target){
//                temp += nums[r];
//                r++;
//            }
//            //（2）窗口出现，尝试收缩左侧，一旦窗口小了，继续扩大右侧
//                while(temp >= target){
//                    mini = Math.min(mini, r-l);
//                    temp -= nums[l];
//                    l++;
//                }
//
//
//        }
//        return mini == Integer.MAX_VALUE ? 0 : mini;
        // 思路2：暴力
        int mini = Integer.MAX_VALUE;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp >= target){
                    mini = Math.min(mini, j-i+1);
                    break;
                }
            }
        }
        return mini == Integer.MAX_VALUE ? 0 : mini;
        // 思路3：i处前缀和（辅助sum[]数组）+二分查找右侧
        // O(NlogN) 一般都是二分
    }
}
