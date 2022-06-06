package NEU.Week05;

import java.util.Stack;

public class hard_TrapRain_42 {
    public int trap(int[] height) {
        // 思路1：（一列一列计算）i处的雨水高度=max(min(左侧最高，右侧最高)-[i]处高度，0)
//        if (height.length <= 2){
//            return 0;
//        }
//        int ans = 0;
//        for (int i = 1; i < height.length - 1; i++) {
//            int leftMax = 0, rightMax = 0;
//            for (int j = 0; j < i; j++) {
//                leftMax = Math.max(height[j], leftMax);
//            }
//            for (int j = i + 1; j < height.length; j++) {
//                rightMax = Math.max(height[j], rightMax);
//            }
//            ans += Math.max(Math.min(leftMax, rightMax) - height[i], 0);
//
//        }
//        return ans;
        // 思路2：（一列一列计算）优化思路1，先用数组保存 从左到右最高、从右到左最高数组;O（N）
//        int len = height.length;
//        int[] leftHeight = new int[len];
//        int[] rightHeight = new int[len];
//        int tempLeft = 0, tempRight = 0;
//        for (int i = 0; i < len; i++) {
//            tempLeft = Math.max(tempLeft, height[i]);
//            leftHeight[i] = Math.max(tempLeft, height[i]);
//        }
//        for (int i = len - 1; i >= 0; i--) {
//            tempRight = Math.max(tempRight, height[i]);
//            rightHeight[i] = Math.max(tempRight, height[i]);
//        }
//        int ans = 0;
//        for (int i = 0; i < len; i++) {
//            ans += Math.max(Math.min(leftHeight[i], rightHeight[i]) - height[i], 0);
//        }
//        return ans;

        /*
         * 思路3：（一列一列计算）双指针，思路1的优化
         * 【边界：while(left<right)】
         * （1）当i右侧很高时，i的高度取决于max(左侧最高的高度-[i],0)
         * （2）当i左侧很高时，同理
         */
//        int left = 0, right = height.length - 1;
//        int leftMax = 0, rightMax = 0;
//        int ans = 0;
//        while (left < right){
//            if (height[right] > height[left]){
//                 leftMax = Math.max(leftMax, height[left]);
//                 ans += leftMax - height[left];
//                 left++;
//            }
//            else {
//                rightMax = Math.max(rightMax, height[right]);
//                ans += rightMax - height[right];
//                right--;
//            }
//        }
//        return ans;

        /*
         * 思路4：单调栈（一层一层计算）
         *  【边界：while(cur<len)】
         * （0）左：peek，中：pop，右：height[cur]
         * （1）当右侧高，看栈pop后是否为空
         * （2.1）空（无水洼、右侧一直高），继续右走
         * （2.2）非空（有水洼）计算水洼宽度、高度
         */
        Stack<Integer> stack = new Stack<Integer>();
        int cur = 0, ans = 0;
        while (cur < height.length){
            // 当右侧比中间高时，计算可能积水
            // 当栈空时，中间不存在，所以要先判断
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]){
                int top = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                // 注意距离
                int width = cur - stack.peek() - 1;
                // 单调栈，peek始终>=pop的
                int curHeight = Math.min(height[cur], height[stack.peek()]) - height[top];
                ans += width * curHeight;
            }
            // pop去除中间后
            // 若peek、cur单调减，不进while循环、两者都会入栈
            // 若peek、cur单调增，进while循环、消耗掉前面的、只留最后一个入栈
            stack.push(cur++);
        }
        return ans;

    }
}
