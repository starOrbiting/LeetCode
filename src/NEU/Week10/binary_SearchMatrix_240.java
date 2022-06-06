package NEU.Week10;

public class binary_SearchMatrix_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 思路1：暴力
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == target){
//                    return true;
//                }
//            }
//        }
//        return false;
        // 思路2：二分
//        for (int i = 0; i < matrix.length; i++) {
//            if (binarySearch(matrix[i],target)){
//                return true;
//            }
//        }
//        return false;
//    }
//    public boolean binarySearch(int[] nums, int target){
//        int l = 0, r = nums.length - 1;
//        int mid = 0;
//        while (l <= r){
//            mid = (r-l)/2+l;
//            if (nums[mid] == target){
//                return true;
//            }
//            else if (nums[mid] < target){
//                l = mid + 1;
//            }
//            else {
//                r = mid - 1;
//            }
//        }
//        return false;
        // 思路3：Z型搜索
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0){
            if (matrix[x][y] == target){
                return true;
            }
            else if (matrix[x][y] < target){
                x++;
            }
            else {
                y--;
            }
        }
        return false;
    }
}
