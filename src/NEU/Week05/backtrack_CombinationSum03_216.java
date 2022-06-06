package NEU.Week05;

import java.util.ArrayList;
import java.util.List;

public class backtrack_CombinationSum03_216 {
    public static void main(String[] args) {
        List<List<Integer>> ans = combinationSum3(3,7);
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        // 思路1：回溯+剪枝
        //（1）包括[0~i~n]之前的数，不用设置index
        //（2）从[i~n]开始、可以重复i，设置index，每次调用(index)
        //（3）从[i~n]开始、不重复i，设置index，每次调用(index+1)
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backtrack(ans, new ArrayList<Integer>(), k, n, 0, 0, 1);
        return ans;
    }
    public static void backtrack(List<List<Integer>> ans, List<Integer> temp, int k, int n, int new_k, int new_n, int index){
        if (n == new_n && k == new_k){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        if (new_k > k || new_n > n){
            return;
        }
        for (int i = index; i <= 9; i++) {
            temp.add(i);
            // 注意index，和其他参数值
            backtrack(ans, temp, k, n, new_k+1, new_n+i, i+1);
            temp.remove(temp.size() - 1);
        }
    }

}
