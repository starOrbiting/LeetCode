package NEU.Week11;

public class string_LongestPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        // 思路： 用第一个和后面对比，count控制相等长度
        if (strs.length == 1){
            return strs[0];
        }
        String s1 = strs[0];
        boolean flag = true;
        int count = 0;

        while (flag){
            for (int i = 1; i < strs.length; i++) {
                if (s1.length() == count || strs[i].length() == count || strs[i].charAt(count) != s1.charAt(count)){
                    flag = false;
                }
            }
            if (flag == true){
                count++;
            }

        }
        return s1.substring(0, count);
    }

}
