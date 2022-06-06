package NEU.Week05;

import java.util.HashMap;
import java.util.Map;

public class hashBit_SingleNum02_137 {

    public int singleNumber(int[] nums) {
        // 思路1：map存储次数，类似字典
//        int ans = 0;
//        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
//        for (int num : nums) {
//            // 重新计算次数，放回map
//            // getOrDefault(num, 0) 返回num的次数，没有返回0
//            freq.put(num, freq.getOrDefault(num, 0) + 1);
//        }
//        // 键值对遍历
//        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
//            if (entry.getValue() == 1){
//                ans = entry.getKey();
//            }
//        }
//        return ans;
        // 思路2： 计算每位，拼接成答案
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            // 找答案的每个1
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            if (total %3 != 0){
                // 拼接ans
                ans = ans | (1 << i);
            }
        }

        return ans;
    }
}
