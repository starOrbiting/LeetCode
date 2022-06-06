package NEU.Week04;

import java.util.ArrayList;
import java.util.List;

public class backtrack_Cmbinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        // 思路：backtrack
        // 注意：剪枝
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backtrack(ans, new ArrayList<Integer>(), k, n, 0);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans, List<Integer> temp, int k, int n, int index){
        if (temp.size() == k){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = index + 1; i <= n; i++) {
            temp.add(i);
            backtrack(ans, temp, k, n, i);
            temp.remove(temp.size() - 1);
        }

    }
}
