package NEU.Week01;

public class dp_ClimbingStairs_70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }
    public static int climbStairs(int n) {
        /*
        思路：（1）f(x)表示爬到x级台阶的方法数（2）什么情况下能爬到第x级呢，在（x-1）级爬1级或（x-2级）时爬两级
             （3）那么f(x)方法数 = f(x-1)方法数 + f(x-2)方法数
             （4）可以用Fibonacci 边界条件：1）0级到0级 1种方法  2）0级到1级 1种方法 f(0)=1,f(1)=1
        直接递归的话会超时，使用滚动数组
         */
//        if (n == 0){
//            return 1;
//        }
//        else if (n == 1){
//            return 1;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);

        int res = 1;
        if (n < 2) {
            return res;
        }
        int first = 1, second = 1;
        for (int i = 0; i < n - 1; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;

    }
}
