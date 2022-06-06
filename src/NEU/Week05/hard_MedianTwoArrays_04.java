package NEU.Week05;

public class hard_MedianTwoArrays_04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 思路：归并排序
        int p1 = 0, p2 = 0, i = 0;
        int len = nums1.length + nums2.length;
        int[] mergeArray = new int[len];
        while (p1 < nums1.length && p2 < nums2.length){
            if (nums1[p1] < nums2[p2]){
                mergeArray[i++] = nums1[p1++];
            }
            else {
                mergeArray[i++] = nums1[p2++];
            }
        }
        while (p1 < nums1.length){
            mergeArray[i++] = nums1[p1++];
        }
        while (p2 < nums2.length){
            mergeArray[i++] = nums1[p2++];
        }
        if (len % 2 == 0){
            return Double.valueOf(mergeArray[len/2] + mergeArray[len/2-1])/2;
        }
        else {
            return mergeArray[len/2];
        }
    }
}
