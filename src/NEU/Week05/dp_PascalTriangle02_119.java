package NEU.Week05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dp_PascalTriangle02_119 {
    public List<Integer> getRow(int rowIndex) {
        // 思路1：dp
//        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
//        for (int i = 0; i < rowIndex + 1; i++) {
//            dp[i][0] = 1;
//            dp[i][i] = 1;
//        }
//        if (rowIndex >= 2){
//            for (int i = 1; i < rowIndex + 1; i++) {
//                for (int j = 1; j < i; j++) {
//                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
//                }
//            }
//        }
//        List<Integer> ans = new ArrayList<Integer>();
//        for (int i = 0; i < rowIndex + 1; i++) {
//            ans.add(dp[rowIndex][i]);
//        }
//        return ans;
        // 思路2：滚动数组优化
        List<Integer> pre = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            // 每一行新的cur
            List<Integer> cur = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    cur.add(1);
                }
                else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            // 滚动
            pre = cur;
        }
        return pre;
    }
}
