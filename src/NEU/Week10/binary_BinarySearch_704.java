package NEU.Week10;

public class binary_BinarySearch_704 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l <= r){
            mid = (r-l)/2+l;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] > target){
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
