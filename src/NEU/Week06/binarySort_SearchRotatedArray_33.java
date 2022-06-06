package NEU.Week06;

public class binarySort_SearchRotatedArray_33 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int a = search(nums, 0);
    }
    public static int search(int[] nums, int target) {
        // 思路：二分
        //（1）mid左右，总有一侧是单调增的
        //（2）判断target是否在单调增一侧，否则在另一侧
        //（3）while结束还没找到target 即不存在
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            //（1）左边单调增
            else if (nums[left] <= nums[mid]){
                if (target >= nums[left] && target <= nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            //（2）右边单调增
            else {
                if (target >= nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
