package NEU.Week06;

import java.util.Arrays;

public class pointer_NextPermutation_31 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        nextPermutation(nums);
    }
    public static void nextPermutation(int[] nums) {
        // 思路：双指针
        //（1）从后向前找到左小、右大，交换
        for (int i = nums.length - 1; i >= 0; i--){
            for (int j = nums.length - 1; j > i; j--){
                if (nums[i] < nums[j]){
                    swap(nums[i], nums[j]);
                    //（2）交换后，按增序重排较小数后面的数字
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
        }
        //（3）最大排序变成最小排序
        Arrays.sort(nums);
        return;
    }
    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        return;
    }
}
