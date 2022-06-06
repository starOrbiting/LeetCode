package NEU.Week03;

import java.util.ArrayList;
import java.util.List;

public class dp_CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*
         * 思路：回溯+剪枝
         */
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        backtrack(ans, temp, candidates, target, 0);
        return  ans;
    }
    public void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] candidates, int rem, int start){
        if (rem == 0){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        if (rem < 0){
            return;
        }
        // i = start，不再和前面的重复组合
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(ans, temp, candidates, rem - candidates[i], i);
            temp.remove(temp.size() - 1);

        }
    }
}
