package NEU.Week03;

public class pointer_FindDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        /*
         * 思路：快慢指针
         * （1）slow走1步，fast走2步
         * （2）当slow和fast相遇后，finder从初始开始同步和slow一起走
         * （3）当slow和finder相遇时，即是重复元素
         */
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int finder = 0;
        while (finder != slow){
            finder = nums[finder];
            slow = nums[slow];
        }
        return finder;
    }
}
