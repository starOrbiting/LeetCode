package NEU.Week01;

import java.util.HashSet;
import java.util.Set;

public class hash_LongestConsecutiveSequence_128 {
    public static void main(String[] args) {

        int[] nums0 = new int[]{1,2,0,1};
        int[] nums1 = new int[]{0,3,7,2,5,8,4,6,0,1};
        int[] nums2 = new int[]{100,4,200,1,3,2};
        int[] nums3 = new int[]{100};
        int[] nums4 = new int[0];
        System.out.println(longestConsecutive(nums0));
        System.out.println(longestConsecutive(nums1));
        System.out.println(longestConsecutive(nums2));
        System.out.println(longestConsecutive(nums3));
        System.out.println(longestConsecutive(nums4));

    }
    public static int longestConsecutive(int[] nums) {
        /*
        思路：（1）时间复杂度为O(N)，不能通过排序去查找下一个数字（2）哈希表查找元素O(1)
        1）遍历hash表，存在前驱的跳过
        2）不存在前驱的进行while循环找后续，每次更新最大长度
        特别：[0,1,2,2,3]的长度是4，可以通过set去重
         */
        
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        int curLen = 0;
        for (int num : set) {
            // 不存在前驱
            if (!set.contains(num - 1)){
                curLen = 1;
                while (set.contains(++num)){
                    curLen++;
                }
                maxLen = Math.max(maxLen, curLen);

            }
        }
        return maxLen;
    }
}
