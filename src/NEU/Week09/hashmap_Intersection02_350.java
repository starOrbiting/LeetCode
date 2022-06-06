package NEU.Week09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hashmap_Intersection02_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 思路1：通过辅助数组判断是否添加过
//        int m = nums1.length, n = nums2.length;
//        int[] visit = new int[m];
//        List<Integer> ans = new ArrayList<Integer>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (nums2[i] == nums1[j] && visit[j] == 0){
//                    ans.add(nums2[i]);
//                    visit[j] = 1;
//                    break;
//                }
//            }
//        }
//        int[] ansInt = ans.stream().mapToInt(x -> x).toArray();
//        return ansInt;
        // 思路2：hashmap存储出现次数
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        Map<Integer,Integer> n = new HashMap<Integer,Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        int len = 0;
        for (int i = 0; i < nums1.length; i++) {
            m.put(nums1[i], m.getOrDefault(nums1[i],0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            n.put(nums1[i], n.getOrDefault(nums2[i],0) + 1);
        }
        for (Integer key : m.keySet()) {
            len = Math.min(m.get(key), n.getOrDefault(key, 0));
            while (len != 0){
                ans.add(key);
                len--;
            }

        }
        int[] ansInt = ans.stream().mapToInt(x -> x).toArray();
        return ansInt;
    }
}
