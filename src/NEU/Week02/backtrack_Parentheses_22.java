package NEU.Week02;

import java.util.ArrayList;
import java.util.List;

public class backtrack_Parentheses_22 {
    public static void main(String[] args) {

    }
    public List<String> generateParenthesis(int n) {
        /*
         * 类似46题（123全排列问题），（不回溯/撤销？的话，子节点会改变祖先节点!）
         * 思路：backtrack
         * （1）判断是否可以加左括号，回溯撤销
         * （2）判断是否可以加右括号，回溯撤销
         * （3）当str填充完时，加入到结果res中
         */
        List<String> res = new ArrayList<String>();
        backtrack(n, res, new StringBuilder(), 0, 0);
        return res;
    }
    // StringBuilder添加速度快
    public static void backtrack(int n, List<String> res, StringBuilder str, int left, int right){
        if (str.length() == 2 * n){
            // add时要转换类型
            res.add(str.toString());
            return;
        }
        // 边界1：保证括号数不超过n
        if (left < n) {
            str.append('(');
            backtrack(n, res, str, left + 1, right);
            str.deleteCharAt(str.length() - 1);
        }
        // 边界2：保证）不超过（，保证括号匹配
        if (right < n){
            str.append(')');
            backtrack(n, res, str, left, right + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }


}
