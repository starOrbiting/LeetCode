package NEU.Week04;

public class pointer_TwoSum02_167 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,25,75};
        int[] ans = twoSum(nums, 100);
    }
    public static int[] twoSum(int[] numbers, int target) {
        // 思路：二分查找另一个数
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            int index = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (index != -1){
                ans[0] = i + 1;
                ans[1] = index + 1;
            }

        }
        return ans;
    }
    public static int binarySearch(int[] nums, int l, int r, int key){
        int mid;
        while (l <= r){
            mid = l + ((r - l) >> 1);
            if (nums[mid] == key){
                return mid;
            }
            else if (nums[mid] < key){
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
