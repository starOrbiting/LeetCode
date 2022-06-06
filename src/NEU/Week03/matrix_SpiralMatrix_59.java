package NEU.Week03;

public class matrix_SpiralMatrix_59 {
    public static void main(String[] args) {
        int[][] ans = generateMatrix(1);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                System.out.printf("%d\t", ans[i][j]);
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n) {
        // 分四段填充
        int[][] ans = new int[n][n];
        int index = 0;
        int k = 1;
        int len;
        while (index < (n / 2)){
            len = n - (2 * index) - 1;
            for (int i = 0; i < len; i++) {
                ans[index][index + i] = k++;
            }
            for (int i = 0; i < len; i++) {
                ans[index + i][n - index - 1] = k++;
            }
            for (int i = 0; i < len; i++) {
                ans[n - index - 1][n - index - i - 1] = k++;
            }
            for (int i = 0; i < len; i++) {
                ans[n - index - i - 1][index] = k++;
            }
            index++;
        }
        if (n % 2 == 1){
            ans[n / 2][n / 2] = n * n;
        }
        return ans;
    }
}
