package NEU.Week03;

public class Matrix_RotateImage_48 {
    public static void main(String[] args) {
        int[][] m = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(m);
    }

    public static void rotate(int[][] matrix) {
        /*
         * 思路1： 拆成一圈一圈，每一圈拆成4段，每次同时交换4段
         * (换的头晕)
         */
//        int n = matrix.length;
//        int index = 0;
//        int len, temp;
//        while (index < (n >> 1)){
//            len = n - 2 * index - 1;
//            for (int i = 0; i < len; i++) {
//                temp = matrix[i + index][index];
//                matrix[i + index][index] = matrix[n - index - 1][i + index];
//                matrix[n - index - 1][i + index] = matrix[n - index - i - 1][n - index - 1];
//                matrix[n - index - i - 1][n - index - 1] = matrix[index][n - i - index - 1];
//                matrix[index][n - i - index - 1] = temp;
//            }
//            index++;
//        }
        /*
         * 思路2：左下-右上对角交换，再水平两侧交换
         */
        int n = matrix.length;
        int temp;
        // 左下-右上对角交换
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 水平两侧交换
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n >> 1); j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }

        }

    }
}
