package NEU.Week10;

public class binary_SearchMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 思路1：Z型搜索
//        int m = matrix.length, n = matrix[0].length;
//        int x = 0, y = n - 1;
//        while (x < m && y >= 0){
//            if (matrix[x][y] == target){
//                return true;
//            }
//            else if(matrix[x][y] > target){
//                y--;
//            }
//            else {
//                x++;
//            }
//        }
//        return false;
        // 思路2：二分
        int l = 0, r = matrix.length - 1;
        int mid = 0, nearRight = -1;
        while (l <= r){
            mid = (r-l)/2+l;
            if (matrix[mid][0] <= target){
                nearRight = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        if (nearRight == -1){
            return false;
        }
        l = 0;
        r = matrix[nearRight].length - 1;
        while (l <= r){
            mid = (r-l)/2+l;
            if (matrix[nearRight][mid] == target){
                return true;
            }
            else if (matrix[nearRight][mid] > target){
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return false;
    }
}
