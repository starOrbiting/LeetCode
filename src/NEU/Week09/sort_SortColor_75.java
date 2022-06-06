package NEU.Week09;

public class sort_SortColor_75 {
    public void sortColors(int[] nums) {
        // 简单排序
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]){
                    swap(nums,i,j);
                }
            }
        }

    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }
}
