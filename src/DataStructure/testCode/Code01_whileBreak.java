package DataStructure.testCode;

public class Code01_whileBreak {
    public static void main(String[] args) {
        // 1. break 会跳出 while 循环
        int x = 10;
        while (x != 0){
            if (x == 6){
                break;
            }
            x--;
        }
        System.out.println(x);
    }
}
