package NEU.Week03;

public class sort_kthLargeElement_215 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }
    public static int findKthLargest(int[] nums, int k) {


        int left = 0, right = nums.length - 1;
        int index;
        while (left <= right){
            index = patition(nums, left, right);
            if (index == k - 1) {
                break;
            }
            else if (index < k - 1){
              left = index + 1;
            }
            else {
                right = index - 1;
            }
        }
        return nums[k];



    }

    public static int patition(int[] nums, int left, int right){

        int val = nums[left];
        while (left <= right){
            if (nums[left] == val){
                left++;
            }
            else if (nums[left] < val){

                swap(nums, left, right);
                right--;
            }
            else {
                swap(nums, left, left - 1);
                left++;
            }
        }
        return left - 1;

    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}
