package NEU.Week02;

import java.util.ArrayList;
import java.util.List;

public class dp_WordBreak_139 {
    public static void main(String[] args) {
        List<String> w = new ArrayList<>();
        w.add("leet");
        w.add("code");
        System.out.println(wordBreak("leetcode",w));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        /*
         * 思路1：dp
         * （1）dp[i]表示i前面是否有解
         * （2）j从[0,i)遍历，如果[j,i)在wordDict里，且dp[j]曾经有解true；那么分割成功，dp[i]=true
         */
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
