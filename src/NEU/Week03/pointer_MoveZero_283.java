package NEU.Week03;

public class pointer_MoveZero_283 {
    public void moveZeroes(int[] nums) {
        // 非0部分重新覆盖，把0挤到后面
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[j] = 0;
        }
    }
}
