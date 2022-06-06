package NEU.Week02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class backtrack_Permutations_46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        permute(nums);

    }
    public static List<List<Integer>> permute(int[] nums) {
        /*
         * 思路：
         * （1）backtrack（n, res, output, first）表示从左往右填到第first个位置，当前排列为output
         * （1.1）如果first=n，说明我们已经填完了n个位置，找到了一个可行的解，我们将output放入答案数组中，递归结束。
         * （1.2）如果first<n，下一个要填位置是first，待填区域有[first,n-1]；
         * （1.2+）假设待填下标是i，每次swap（i和first），继续递归，结束后要再swap（i和first）、撤销
         * 为什么要撤销？？？ 不撤销会造成[first,n-1]和原序列不一致，即存在已填过的数，又存在没填过的数，所以必须交换进行撤销
         */
        // 1. 先创建res，为了每次添加结果时类型匹配，创建output
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        // 2.
        backtrack(n, res, output, 0);
        return res;

    }
    public static void backtrack(int n, List<List<Integer>> res, List<Integer> output, int first){
        if (first == n){
            // Q:为什么不能直接res.add(output)
            // A:output是引用类型，会造成res里的结果都是一样的
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backtrack(n, res, output, first + 1);
            Collections.swap(output, first, i);
        }
    }
}
