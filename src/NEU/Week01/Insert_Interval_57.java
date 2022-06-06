package NEU.Week01;

import java.util.ArrayList;
import java.util.List;

public class Insert_Interval_57 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2}, {3,5}, {6,7},{8,10},{12,16}};
        int[] newInterval = new int[]{4,8};
        int[][] res = insert(intervals,newInterval);
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        思路：（1）以待插入区间S为参考标准 （2）遍历原区间可分为3类：直接插左边、直接插右边、重合更新S区间
        特别的：（1）第一次插右区间，需要先插一次S区间 （2）更新后的S区间是最右侧的，遍历插入完原区间，最后插一次S区间
         */
        /*
        使用ArrayList可以动态修改数组，没有大小限制
        List<Integer> A = new ArrayList<Integer>();  A[int,int,int,...] 一维数组
        List<int[]> B = new ArrayList<int[]>();  A[int[],int[],int[],...] 二维数组
        */
        // 1. 先创建动态列表
        ArrayList<int[]> res = new ArrayList<int[]>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        // 2. 添加新的不重合区间
        for (int[] interval : intervals) {
            // (1) 不重合左区间
            if (interval[1] < left) {
                res.add(interval);
            }
            // (2) 不重合右区间，在放第一个右区间前，先添加带插入区间[left,right]
            else if (interval[0] > right) {
                // 在放右侧第一个区间时，先添加一次【更新】后的[left，right]
                if (!placed) {
                    res.add(new int[]{left,right});
                    placed = true;
                }
                // 后续放右区间时，直接add
                res.add(interval);
            }
            // (3) 重合区间，更新min(left)、max(right)
            else{
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }
        // (4) 待插入区间在最右侧，特别插入一次
        if (!placed) {
            res.add(new int[]{left,right});
        }

        // 3. ArrayList 转 int[][]
        int[][] resInterval = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            // int[] = int[]
            resInterval[i] = res.get(i);
        }
        return resInterval;
    }
}
