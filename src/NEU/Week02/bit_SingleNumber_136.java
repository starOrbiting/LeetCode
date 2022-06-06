package NEU.Week02;

public class bit_SingleNumber_136 {
    public int singleNumber(int[] nums) {
        /*
         * 思路：异或 ^
         * 根据异或性质：N^N=0, N^0=N
         * 偶数次的数字异或后全为0，0和剩下的N异或=N（奇数次）
         */
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        return eor;
    }
}
