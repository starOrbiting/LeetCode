package NEU.Week01;

public class dp_HouseRobber2_213 {
    public static void main(String[] args) {

    }
    public int rob(int[] nums) {
        /*
         * 变成环形：（1）选1不选尾（2）选尾不选1
         * 把原数组分成两部分，又变成198的题目，注意边界、数组长度
         */
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, nums.length - 1), robRange(nums, 1, nums.length));
    }
    public int robRange(int[] nums, int start, int end){
        int a = nums[start];
        if (end - start < 2){
            return a;
        }
        int b = Math.max(nums[start], nums[start + 1]);
        int c = b;
        for (int i = start + 2; i < end; i++) {
            c = Math.max(nums[i] + a, b);
            a = b;
            b = c;
        }
        return c;
    }
}
