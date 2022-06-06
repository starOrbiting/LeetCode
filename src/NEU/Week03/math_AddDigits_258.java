package NEU.Week03;

public class math_AddDigits_258 {
    public int addDigits(int num) {
        // 方法1：更新num
//        while(num >= 10){
//            num = (num % 10) + (num / 10);
//        }
//        return num;
        // 方法2：辅助更新
        while (num >= 10){
            int sum = 0;
            while (num > 0){
                sum += num % 10;
                num = num / 10;
            }
            num = sum;
        }
        return num;


    }
}
