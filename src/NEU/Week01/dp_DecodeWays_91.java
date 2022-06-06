package NEU.Week01;

public class dp_DecodeWays_91 {
    public static void main(String[] args) {
        String s = "012";
        System.out.println(numDecodings(s));
//        System.out.println("3"+"4");
    }
    public static int numDecodings(String s) {
       /*
        * 思路1：自底向上 dp
        * 对动态规划 推导进行优化【错误的推导思路，会导致复杂的求解过程】
        * （1）明确dp[i]：以s[i-1]结尾的方法数【为什么多一个辅助空间dp[0]?因为后期发现取[i-2]时 方便】
        * （2）dp[i]怎么求：
        * （2.1）向前取一位-> ab
        * （2.2）dp[i] = dp[i-1]当b可以单独编码时 + dp[i-2]当ab可以一起编码时
        * （2.3）dp[i]初始为0，表示dp[i]无解，后续填充dp，[i]可能有解/无解
        * （2.4）最后返回dp最后一个
        */
        // 不使用辅助dp[0]
//        int[] dp = new int[s.length()];
//        // 1. 最小子问题
//        dp[0] = s.charAt(0) == '0' ? 0 : 1;
//        int twoDigit;
//        for (int i = 1; i < s.length(); i++) {
//            // 2. ab开始分类讨论
//            // (1) b可以单独编码吗？
//            if ((s.charAt(i) - 48) > 0){
//                // 可以单独编码
//                dp[i] += dp[i - 1];
//            }
//            // （2）ab可以一起编码吗？
//            twoDigit = Integer.valueOf(s.substring(i - 1, i + 1));
//            if (twoDigit >= 10 && twoDigit <= 26){
//                // ab一组编码
//                // 当i=1时，dp[i-2]会越界，特别判断一下i-2是否越界
//                if (i - 2 >= 0){
//                    dp[i] += dp[i - 2];
//                }
//                else {
//                    dp[i] += 1;
//                }
//            }
//        }
//        return dp[s.length() - 1];
        /*
         * 优化：使用滚动数组
         * （1）m[i-2],a[i-1],b[i]
         * （2）对于ab分类讨论：1）b可以单独编码 b+=a； 2）ab可以一起编码 b+=m； 3）滚动数组
         */
        int m = 0,a = 0, b = 0;
        int twoDigit;
        a = s.charAt(0) != '0' ? 1 : 0;
        b = a;
        for (int i = 1; i < s.length(); i++) {
            b = 0;
            if (s.charAt(i) != '0') {
                b += a;
            }
            twoDigit = Integer.valueOf(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26){
                if (i - 2 >= 0){
                    b += m;
                }
                else {
                    b += 1;
                }
            }
            m = a;
            a = b;
        }
        return b;
    }
}
