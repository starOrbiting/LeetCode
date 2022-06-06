package NEU.Week09;

import java.util.Arrays;
import java.util.Comparator;

public class math_CarFleet_853 {
    public int carFleet(int target, int[] position, int[] speed) {
        // 思路：[i-1]的时间<=[i]必相遇，同时速度和[i]一致；否则两车永不相遇，车队+1
        // 为什么要从离终点近的先开始？
        // [i-2] [i-1] [i]，[i-1]不受[i-2]影响，但受[i]影响，所以从后向前
        int N = position.length;
        if (N < 2){
            return N;
        }
        double[][] cars = new double[N][2];
        int count = 0;
        for (int i = 0; i < N; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i])/speed[i];
        }
        Arrays.sort(cars, Comparator.comparingDouble(a -> a[0]));
        for (int i = N - 1; i > 0; i--) {
            if (cars[i - 1][1] > cars[i][1]){
                //追不上，多加一组
                count++;
            }
            else {
                //能追上，速度变成慢的，他们变成一组
                cars[i - 1][1] = cars[i][1];
            }
        }
        return count + 1;

    }

}
