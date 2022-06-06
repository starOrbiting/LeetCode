package NEU.Week08;

import java.util.*;

public class ListMap_InsertDeleteRandomO1_380 {
}
class RandomizedSet {
    // 思路：变长数组 + 哈希表
    // 变长数组：O(1) 获取随机元素
    // 哈希表：O(1)判断元素是否存在
    // 变长数组中存储元素，哈希表中存储每个元素在变长数组中的（值和下标）
    List<Integer> nums;
    Map<Integer, Integer> maps;

    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        maps = new HashMap<Integer, Integer>();
    }

    public boolean insert(int val) {
        if (maps.containsKey(val)){
            return false;
        }

        maps.put(val,nums.size());
        nums.add(val);
        return true;

    }

    public boolean remove(int val) {
        if (!maps.containsKey(val)){
            return false;
        }
        int index = maps.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index, last);
        maps.put(last, index);
        maps.remove(val);
        nums.remove(nums.size() - 1);
        return true;

    }

    public int getRandom() {
        int randomIndex = new Random().nextInt(nums.size());
        return nums.get(randomIndex);
    }
}