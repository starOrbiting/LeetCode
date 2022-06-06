package NEU.Week02;

public class dp_JumpGame_55 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,3,1,1,4};
        System.out.println(canJump(nums1));
    }
    public static boolean canJump(int[] nums) {
        /*
         * 思路1：O(N2)
         * 对于i位置，遍历前（i-1）个，看看能不能到i位置
         */
//        boolean flag;
//        for (int i = 1; i < nums.length; i++) {
//            flag = false;
//            for (int j = 0; j < i; j++) {
//                if (j + nums[j] >= i){
//                    flag = true;
//                }
//            }
//            if (flag == false){
//                return false;
//            }
//        }
//        return true;
        /*
         * 思路2：O(N)
         * 看最大距离maxLen能否大于i，不大于返回false，大于继续更新maxLen
         */
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxLen < i){
                return false;
            }
            maxLen = Math.max(maxLen, i + nums[i]);

        }
        return true;
    }
}
