package NEU.Week08;

import java.util.HashMap;
import java.util.TreeMap;

public class treeMap_TimeKeyValue_981 {
}
class TimeMap {
    // 思路：HashMap+TreeMap
    HashMap<String, TreeMap<Integer, String>>  map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)){
            map.put(key, new TreeMap<Integer, String>());
        }
        TreeMap<Integer, String> temp = map.get(key);
        temp.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)){
            return "";
        }
        TreeMap<Integer, String> temp = map.get(key);
        if (temp.containsKey(timestamp)){
            return temp.get(timestamp);
        }
        // temp.floorKey(key) 方法调用返回小于或等于key的最大键；如果没有这样的键，则返回null
        if (temp.floorKey(timestamp) != null){
            return temp.get(temp.floorKey(timestamp));
        }
        return "";


    }
}
