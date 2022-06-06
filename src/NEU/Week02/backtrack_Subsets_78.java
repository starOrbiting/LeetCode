package NEU.Week02;

import java.util.ArrayList;
import java.util.List;

public class backtrack_Subsets_78 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        /*
         * 思路1：回溯
         * （1）[0,cur-1]是状态确定的，[cur,n-1]状态为止
         * （2）在给cur状态时
         * （2.1）可以选cur（放入答案数组，再回溯撤销）->进入bt(cur+1)，
         * （2.2）也可以不选->进入bt(cur+1)
         */
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        backtrack(res, 0, nums, new ArrayList<Integer>());
//        return res;
        /*
         * 思路2：bit
         * （1）对于总长度n的数组，每个i位置的状态有两种：在子集1，不在子集0。
         * （2）可以对应为长度n的0/1序列，0~2^n-1
         * （2.1）num属于[0,2^n-1]，找到num内部为1的全部位（在子集中），添加到结果中
         */
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        int n = nums.length;
        for (int num = 0; num < (1 << n); num++) {
            temp.clear();
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0){
                    temp.add(nums[i]);
                }
            }
            res.add(new ArrayList<Integer>(temp));
        }
        return res;
    }
//    public void backtrack(List<List<Integer>> res, int cur, int[] nums, List<Integer> temp){
//        if (cur == nums.length){
//            res.add(new ArrayList<Integer>(temp));
//            return;
//        }
//        // （1）[cur]被选中，在子集中，进入下一个位置
//        temp.add(nums[cur]);
//        backtrack(res, cur + 1, nums, temp);
//        temp.remove(temp.size() - 1);
//        // （2）[cur]不在子集中，进入下一个位置
//        backtrack(res, cur + 1, nums, temp);
//    }
}
