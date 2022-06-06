//package NEU.Week10;
//
//public class pointer_LongestSubset_524 {
//    public String findLongestWord(String s, List<String> dictionary) {
//        // 思路：双指针，判断是否是子串
//        String res = "";
//        for (String str : dictionary) {
//            int i = 0, j =0;
//            while (i < str.length() && j < s.length()){
//                if (str.charAt(i) == s.charAt(j)){
//                    i++;
//                    j++;
//                }
//                else {
//                    j++;
//                }
//            }
//            // 是s的子集
//            // 注意！i满足条件退出循环时=str.length
//            if (i == str.length()){
//                // 判断是不是最长或字典序最小的
//                if (str.length() > res.length() || (str.length() == res.length() && str.compareTo(res) < 0)){
//                    res = str;
//                }
//            }
//        }
//        return res;
//    }
//}
