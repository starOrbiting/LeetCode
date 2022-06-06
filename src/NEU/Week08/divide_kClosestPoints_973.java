package NEU.Week08;


import java.util.*;

public class divide_kClosestPoints_973 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{3,3},{5,-1},{-2,4}};
        kClosest(nums,2);
        List<Integer> l1 = new ArrayList<Integer>();


    }
    public static int[][] kClosest(int[][] points, int k) {
        // 思路1：快排
        //（1）左侧小，中间等，右侧大
        //（2）当iPos=k时，直接返回此时排序即可，因为k左侧全是小的
//        quickSort(points, 0, points.length - 1, k);
//        return Arrays.copyOfRange(points,0,k);

        // 思路2：sort方法，修改比较器
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return (p1[0]*p1[0] + p1[1]*p1[1]) - (p2[0]*p2[0]+p2[1]*p2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, k);

    }
    public static void quickSort(int[][] points, int l, int r, int k){
        int randomPos = new Random().nextInt(r - l + 1) + l;
        int randomDis = distance(points[randomPos]);
        int lPos = l - 1, rPos = r + 1, iPos = l;
        while(iPos < rPos){
            if (distance(points[iPos]) == randomDis){
                iPos++;
            }
            else if (distance(points[iPos]) < randomDis){
                lPos++;
                swap(points, iPos, lPos);
                iPos++;
            }
            else {
                rPos--;
                swap(points, iPos, rPos);
            }
        }
        if (iPos == k){
            return;
        }
        else if(iPos < k){
            quickSort(points, iPos, r, k);
        }
        else {
            quickSort(points, l, iPos - 2, k);
        }



    }
    public static void swap(int[][] points, int a, int b){
        int[] temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }
    public static int distance(int[] num){
        return num[0]*num[0] +num[1]*num[1];
    }

}
